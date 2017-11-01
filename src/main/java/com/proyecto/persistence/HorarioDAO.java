/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.proyecto.transferObject.HorarioTO;

/**
 *
 * @author Nicolas
 */
public class HorarioDAO {

	private static final String OBTENER_HORARIO_DISPONIBLE = "select * from horario";
	private static final String ACTUALIZAR_RACIONES_HORARIO = "update horario set cantMaxRaciones=cantMaxRaciones-1 where id=?";

	private static final String VERIFICAR = "select * from horario where cantMaxRaciones>0";

	private static final String DB_NAME = "mydb";
	private static final String PORT = "3306";
	private static final String URL = "jdbc:mysql://localhost:" + PORT + "/" + DB_NAME;
	private static final String USER = "root";
	private static final String PASSWORD = "";

	public void actualizaRacionesHorario(int idHorario) {
		Connection conn = null;
		try {
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(ACTUALIZAR_RACIONES_HORARIO);
			ps.setInt(1, idHorario);
			ps.executeUpdate();
		} catch (SQLException e) {

		}
	}

	public boolean verificarhorario() {
		Connection conn = null;
		try {
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(VERIFICAR);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {

		}
		return false;
	}

	public LinkedList<HorarioTO> obtenerHorarioDisponible() {
		LinkedList<HorarioTO> list = new LinkedList<>();
		Connection conn = null;
		HorarioTO result = null;
		try {
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(OBTENER_HORARIO_DISPONIBLE);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				result = new HorarioTO();
				result.setId(rs.getInt("id"));
				result.setHoraInicio(rs.getTime("horaInicio"));
				result.setHoraFin(rs.getTime("horaFin"));
				result.setCantMaxRaciones(rs.getInt("cantMaxRaciones"));
				list.add(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Quedo la pata hermano!!!");
		}
		return list;
	}

	private static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
			System.err.println("Quedo la pata hermano!!!");
		}
		return conn;
	}
}
