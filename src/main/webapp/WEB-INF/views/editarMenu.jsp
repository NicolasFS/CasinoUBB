<%-- 
    Document   : editarMenu
    Created on : 14-10-2017, 18:23:48
    Author     : Marcosz
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="cabecera.jsp"%>
<!-- HTML meta refresh URL redirection -->

</head>

<body class="no-skin">
	<div id="navbar" class="navbar navbar-default          ace-save-state">
		<%@ include file="barraSuperior.jsp"%>
	</div>

	<div class="main-container ace-save-state" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.loadState('main-container')
			} catch (e) {
			}
		</script>

		<div id="sidebar"
			class="sidebar                  responsive                    ace-save-state">
			<script type="javascript">
					try{ace.settings.loadState('sidebar')}catch(e){}
				</script>
			<%@ include file="barraLateral.jsp"%>

			<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
				<i id="sidebar-toggle-icon"
					class="ace-icon fa fa-angle-double-left ace-save-state"
					data-icon1="ace-icon fa fa-angle-double-left"
					data-icon2="ace-icon fa fa-angle-double-right"></i>
			</div>
		</div>

		<div class="main-content">
			<!--inicio contenido-->
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">


					<div class="nav-search" id="nav-search">
						<form class="form-search">
							<span class="input-icon"> <input type="text"
								placeholder="Buscar ..." class="nav-search-input"
								id="nav-search-input" autocomplete="off" /> <i
								class="ace-icon fa fa-search nav-search-icon"></i>
							</span>
						</form>
					</div>
					<!-- /.nav-search -->
				</div>

				<div class="page-content">

					<div class="page-header"></div>
					<!-- /.page-header -->


					<h2>Menú</h2>
					
					<table class="table table-condensed" style="width: 1000px">
						<thead>
							<tr>
								<th>Id</th>
								<th>Nombre</th>
								<th>Precio</th>
								<th>Tipo</th>
								<th>Editar</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row">1</th>
								<td>Porotos</td>
								<td>2000</td>
								<td>Normal</td>
								<td><a href="actualizarMenu.htm">Editar</a></td>
							</tr>
							<tr>
								<th scope="row">2</th>
								<td>Arroz con pollo</td>
								<td>2000</td>
								<td>Normal</td>
								<td><a href="actualizarMenu.htm">Editar</a></td>
							</tr>
							<tr>
								<th scope="row">3</th>
								<td>Arroz con papas fritas</td>
								<td>3000</td>
								<td>Extra</td>
								<td><a href="actualizarMenu.htm">Editar</a></td>
							</tr>
						</tbody>
					</table>

					<div align="left">
						<a href="buscarMenu2.htm"><button type="submit"
								class="btn btn-default">Volver</button></a>
					</div>

				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.page-content -->
	</div>

	<!-- /.main-content -->

	<div class="footer">
		<%@ include file="pieDePagina.jsp"%>
	</div>

	<a href="#" id="btn-scroll-up"
		class="btn-scroll-up btn btn-sm btn-inverse"> <i
		class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
	</a>

	<!-- /.main-container -->



	<%@ include file="scripts.jsp"%>
</body>


</html>