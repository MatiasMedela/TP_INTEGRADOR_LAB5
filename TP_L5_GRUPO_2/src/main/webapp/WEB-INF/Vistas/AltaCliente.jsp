<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- JS, Popper.js, and jQuery -->
	<script 
	src="https://code.jquery.com/jquery-3.5.1.slim.min.js" 
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" 
	crossorigin="anonymous"></script>
	
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
	<script 
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" 
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" 
	crossorigin="anonymous"></script>
<!-- CSS only -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" 
	crossorigin="anonymous">

<script type="text/javascript">


function ValFormatoTelCel(){
	var TelTxt = document.querySelector('#TelId');

	TelTxt.disabled = false;
	TelTxt.setAttribute("placeholder", "ej: 1126208736");
	TelTxt.setAttribute("pattern", "\([1-1]{2}\)[0-9]{8}");
	
}

function ValFormatoTelFijo(){
	var TelTxt = document.querySelector('#TelId');

	TelTxt.disabled = false;
	TelTxt.setAttribute("placeholder", "ej: 0123-489354");
	TelTxt.setAttribute("pattern", "\([0-9]{4}\) [0-9]{3}[ -][0-9]{3}");
	
}
</script>
<meta charset="ISO-8859-1">
<title>Alta Cliente</title>
</head>
<body>
	<!-- NAVBAR -->
	<jsp:include page="NavbarAdmin.html"></jsp:include>
	<!-- END NAVBAR -->
<!-- Formulario alta -->
<form style="padding: 20px"> 
	<fieldset class="border p-2">
	  <legend  class="w-auto">Alta Cliente</legend>
	   <div class="container-fluid">
		  <div class="row row-cols-2">
			<div class="col">
			 <div class="form-group"> <!-- DNI -->
		        <label for="full_name_id" class="control-label">Numero De Documento</label>
		        <input type="number" class="form-control form-control-sm" id="DniID" name="DniName" placeholder="D.N.I" 
		         min="8" max="8" pattern="^[0-9]*$" autocomplete="off" required>
		    </div>  
		    <div class="form-group"> <!-- Nombre -->
		        <label for="full_name_id" class="control-label">Nombre</label>
		        <input type="text" class="form-control form-control-sm" id="NombreId" name="NombreName" placeholder="NOMBRE" 
		        autocomplete="off" pattern="^[a-zA-Z ]*$" required>
		    </div>    
		    <div class="form-group"> <!-- Apellido -->
		        <label for="full_name_id" class="control-label">Apellido</label>
		        <input type="text" class="form-control form-control-sm" id="ApeId" name="ApeName" placeholder="APELLIDO" 
		        autocomplete="off" pattern="^[a-zA-Z ]*$" required>
		    </div> 
		    <div class="form-group"> <!-- Nacionalidad -->
		        <label for="full_name_id" class="control-label">Nacionalidad</label>
		        <input type="text" class="form-control form-control-sm" id="full_name_id" name="full_name" placeholder="NACIONALIDAD" 
		        autocomplete="off" pattern="^[a-zA-Z ]*$" required>
		    </div> 
		    
		    <div class="form-group"> <!-- Sexo -->
		        <label for="state_id" class="control-label">Sexo</label>
		        <select class="form-control form-control-sm" id="state_id">
		            <option value="MAS">Masculino</option>
		            <option value="FEM">Femenino</option>
		            <option value="OTR">Otro</option>
		        </select>                    
		    </div>
		    
		</div>
		<div class="col">
		    <div class="form-group "><!-- Fecha De Nacimiento -->
		     <label for="full_name_id" class="control-label">Fecha De Nacimiento</label>
			    <input class="form-control form-control-sm" type="date"  id="example-date-input" required>
			</div>
		   <div class="form-group"> <!-- Direccion -->
		        <label for="full_name_id" class="control-label">Direccion</label>
		        <input type="text" class="form-control form-control-sm" id="full_name_id" name="full_name" 
		        placeholder="DIRECCION" required>
		    </div>
		     <div class="form-group"> <!-- Provincia -->
		        <label for="state_id" class="control-label">Provincia</label>
		        <select class="form-control form-control-sm" id="state_id">
		            <option value="BSAS">Buenos Aires</option>
		            <option value="CABA">Ciudad Autonoma De Buenos Aires</option>
		            <option value="TUC">Tucuman</option>
		            <option value="ER">Entre Rios</option>
		            <option value="MIS">Misiones</option>
		            <option value="FOR">Formosa</option>
		            <option value="COR">Corrientes</option>
		            <option value="SF">Santa Fe</option>
		            <option value="COR">Cordoba</option>
		            <option value="JUJ">Jujuy</option>
		            <option value="CHU">Chubut</option>
		            <option value="TDF">Tierra Del Fuego</option>
		            <option value="NEU">Neuquen</option>
		            <option value="IL">Chaco</option>
		            <option value="IN">San Juan</option>
		            <option value="IA">San Luis</option>
		            <option value="KS">La Pampa</option>
		            <option value="KY">Santa Cruz</option>
		            <option value="LA">Salta</option>
		            <option value="ME">Catamarca</option>
		            <option value="MD">La Rioja</option>
		            <option value="MA">Santiago Del Estero</option>
		            <option value="MI">Mendoza</option>
		        </select>                    
		    </div>       
		    <div class="form-group"> <!-- Localidad -->
		        <label for="full_name_id" class="control-label">Localidad</label>
		        <input type="text" class="form-control form-control-sm" id="full_name_id" name="full_name" placeholder="LOCALIDAD" 
		        required>
		    </div>                
		    
		     <div class="form-group"> <!-- Correo electronico -->
		        <label for="full_name_id" class="control-label">Correo Electronico</label>
		        <input type="email" class="form-control form-control-sm" id="full_name_id" name="full_name" placeholder="e-mail" 
		        required>
		    </div> 
		    
		    <div class="form-group"> <!-- Telefono -->
		        <label for="full_name_id" class="control-label">Numero de telefono</label>
				<div class="form-check form-check-inline" style="padding-left: 10px">
				  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="RadTelFijo" 
				 onclick="ValFormatoTelFijo()" >
				  <label class="form-check-label" for="inlineRadio1">Fijo</label>
				</div>
				<div class="form-check form-check-inline">
				  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="RadCel" value="option2" 
				  onclick="ValFormatoTelCel()">
				  <label class="form-check-label" for="inlineRadio2">Celular</label>
				</div>
		        <input type="tel" class="form-control form-control-sm" id="TelId" name="CliTel" placeholder="Telefono" 
		         title=" Respete el formato"   pattern=""  disabled required >
		    </div>
		    
		</div>   
		</div>  
		<div class="form-group text-center" > <!-- Submit Button -->
	        <button type="submit" class="btn-sm btn-success">Grabar</button>
	    </div>     
	</div>
	</fieldset>  
</form>
<!--Fin Formulario alta -->

<!-- modal cerrar session  -->
<div class="modal fade" id="ModalCerrarSession" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Cerrar Sesion</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">�Desea cerrar la sesion?</div>
      <div class="modal-footer">
     <form action="#" method="post" accept-charset=utf-8>
     <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
	 <button type="Submit" class="btn btn-primary" name="BtnCerrarSesion" >Cerrar Sesion</button>		
		</form>
      </div>
    </div>
  </div>
</div>  
<!-- modal cerrar session  -->

</body>
</html>