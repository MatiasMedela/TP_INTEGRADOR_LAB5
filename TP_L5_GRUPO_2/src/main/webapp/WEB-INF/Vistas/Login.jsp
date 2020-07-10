<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
 <meta charset="utf-8">
 <meta name="viewport" content="initial-scale=1, shrink-to-fit=no">
 
<!-- JS, Popper.js, and jQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	
<!-- Bootstrap CSS y Script -->	
	<script 
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" 
	crossorigin="anonymous"></script>
	
	<script 
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" 
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" 
	crossorigin="anonymous"></script>
	
	<!-- Hoja de estilos-->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" 
	crossorigin="anonymous">

<!-- Los iconos tipo Solid de Fontawesome-->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
<script src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>
<!-- Hoja de estilos-->
<link rel=stylesheet href="<c:url value="resources/Estilos/Login.css"/>" type="text/css" media=screen>
	
<script type="text/javascript">
function ValidarFormulario(){
	var datos={
		"Username":$("#UsernameId").val(),	
		"Key":$("#KeyId").val(),	
	}
	$.ajax({
		type: "POST",
		url:'${request.getContextPath()}/TP_L5_GRUPO_2/ValidarLoginAsync.html',
		data:datos,
		success:function(Res){
			if ( Res == "\"Valido\"") {
				document.getElementById("UsernameId").style.border="1px solid green";
				document.getElementById("KeyId").style.border="1px solid green";
				$("#VerificarLogId").submit();
				  } else {
					  if(Res == "\"InvalidoKey\""){
						  	document.querySelector('#IdLabelKey').innerText = 'Contraseña invalida';
							document.getElementById("IdLabelKey").style.color="red";
							document.getElementById("KeyId").style.border="1px solid red";
					  }else{
						    document.querySelector('#IdLabelUserName').innerText = 'Nombre de usuaio invalido';
						    document.querySelector('#IdLabelKey').innerText = 'Contraseña invalida';
							document.getElementById("IdLabelUserName").style.color="red";
							document.getElementById("UsernameId").style.border="1px solid red";
							document.getElementById("IdLabelKey").style.color="red";
							document.getElementById("KeyId").style.border="1px solid red";
					   }
				 }
		}
	});
}
</script>
<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=yes">
<title>Login</title>
</head>
<body>
<div class="modal-dialog text-center">
	<div class="col-sm-8 main-section">
		<div class="modal-content">
			<div class="col-12 user-img">
			<img src="<c:url value="resources/Imagenes/login_user.jpg"/>" alt="">
			</div>
			<form class="col-12" action="VerificarLog.html" method="post" id="VerificarLogId">
				<div class="form-group" id="user-group">
					<input type="text" class="form-control" placeholder="Nombre De Usuario" id="UsernameId" name="LoginUser" autocomplete="off" style="border-bottom-color: black;" required/>
					<label for="full_name_id" id="IdLabelUserName" class="control-label"></label>
				</div>
				<div class="form-group" id="contrasena-group">
					<input type="password" class="form-control" placeholder="Contrasena" id="KeyId" name="LoginKey"  required/>
					<label for="full_name_id" id="IdLabelKey" class="control-label"></label>
				</div>
				<button type="button" class="btn btn-primary" name="BtnIngresar" style="color:#102D97;background-color: #D2C132" onclick="return ValidarFormulario()">Ingresar</button>
			</form>
		</div>
	</div> 
</div>
</body>
</html>