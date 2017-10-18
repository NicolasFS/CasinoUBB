/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import com.proyecto.transferObject.MenuTO;

/**
 *
 * @author Nicolas
 */
public class MenuDAO {

    private static final String BUSCA_MENU="select * from menu where fecha=?";
    private static final String OBTENER_MENU="select * from menu where fecha=?";
    
    
    private static final String DB_NAME = "mydb";
    private static final String PORT = "3306";
    private static final String URL = "jdbc:mysql://localhost:" + PORT + "/" + DB_NAME;
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public int buscaMenu(MenuTO menu){
        Connection conn=null;
        try{
            conn=getConnection();
            PreparedStatement ps=conn.prepareStatement(BUSCA_MENU);
            ps.setDate(1, menu.getFecha());
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                return 1;
            }
            
        }catch(SQLException e){
            
        }
        return 0;
    }
    
    public LinkedList <MenuTO> obtieneMenu(MenuTO menu){
        Connection conn= null;
        LinkedList <MenuTO>lista=new LinkedList<>();
        MenuTO result=null;
        try{
            conn=getConnection();
            PreparedStatement ps=conn.prepareStatement(OBTENER_MENU);
            ps.setDate(1, menu.getFecha());
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                result=new MenuTO();
                result.setId(rs.getInt("id"));
                result.setNombre(rs.getString("nombre"));
                result.setPrecio(rs.getInt("precio"));
                result.setTipo(rs.getString("tipo"));
                result.setFecha(rs.getDate("fecha"));
                lista.add(result);
            }
            
        }catch(SQLException e){
           
        }
        return lista;
    }
    public int ingresaMenu(String nombre, String tipo, String precio, Date fecha) {
    	int result =0;
    	return result;
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