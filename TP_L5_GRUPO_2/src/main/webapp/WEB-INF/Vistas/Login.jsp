<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=yes">
<title>Login</title>
<!-- JQUERY -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Required meta tags -->
 <meta charset="utf-8">
 <meta name="viewport" content="initial-scale=1, shrink-to-fit=no">
    
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" 
crossorigin="anonymous">

<!-- Los iconos tipo Solid de Fontawesome-->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
<script src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>
<!-- Hoja de estilos-->
<link rel="stylesheet" type="text/css" href="../../Estilos/Login.css">
</head>
<body>
<div class="modal-dialog text-center">
	<div class="col-sm-8 main-section">
		<div class="modal-content">
			<div class="col-12 user-img">
			<img src="../../Imagenes/login_user.jpg">
			</div>
			<form class="col-12" action="ServletLogin" method="post" accept-charset=utf-8>
				<div class="form-group" id="user-group">
				<input type="text" class="form-control" placeholder="Nombre De Usuario" name="LoginUser" autocomplete="off" required/>
				</div>
			<div class="form-group" id="contrasena-group">
				<input type="password" class="form-control" placeholder="Contrasena" name="LoginKey"  required/>
				</div>
				<button type="submit" class="btn btn-primary" name="BtnIngresar" style="color:#102D97;background-color: #D2C132">
				Ingresar
				</button>
			</form>
<%
//boolean Ingresouser=true,Ingresokey=true,exist=true;
//if(request.getAttribute("UsuarioInvalido")!=null){Ingresouser=(boolean)request.getAttribute("UsuarioInvalido");}
 // if(request.getAttribute("ContraseñaInvalida")!=null){Ingresokey=(boolean)request.getAttribute("ContraseñaInvalida");}
 //	if(request.getAttribute("usuarionoexiste")!=null){exist=(boolean)request.getAttribute("usuarionoexiste");}
%>
<%
//if(Ingresouser == false && exist == true){
%>
<!--
<div class="alert alert-danger" >
<strong>Usuario Invalido</strong>
</div>-->
<%//}
//else{
//if(Ingresokey == false && exist == true){
%>
<!--
<div class="alert alert-danger" >
<strong>Contraseña Invalida</strong>
</div>-->
<%//}
//}%>
<%
//if(Ingresouser == false && Ingresokey == false && exist == false){
%>
<!-- <div class="alert alert-danger" >
<strong>Usuario no existe</strong>
</div>-->
<%//}%>
		</div>
	</div> 
</div>

	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
   <!-- <script src=" /TP_integrador_Font_Sebastian/js/Login.js"></script> --> 
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" 
    crossorigin="anonymous"></script>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" 
    integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" 
    crossorigin="anonymous"></script>
    
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" 
    integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" 
    crossorigin="anonymous"></script>
</body>
</html>