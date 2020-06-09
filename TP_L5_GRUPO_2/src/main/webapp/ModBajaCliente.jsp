<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, minimum-scale=1.0">
<meta charset="ISO-8859-1">
<!-- Jquery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<!-- Bootstrap CSS y Script -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<!-- JS, Popper.js -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

<!-- Data Tables -->
<script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap4.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"/>


<script type="text/javascript">
$(document).ready(function() {
	 $('#TClientes').DataTable( {
         "scrollX": true,
         "scrollY": 350,
         sDom: '<"top"fli>t<"bottom"p><"clear">r',
         sPaginationType: "full_numbers",
         bProcessing: true,
         bAutoWidth: true,
         "sScrollX": "100%",
         "sScrollXInner": "100%",
         language: {
	             decimal: "",
	             emptyTable: "No se han encontrado registros",
	             info: "Mostrando desde el _START_ al _END_ del total de _TOTAL_ registros",
	             infoEmpty: "Mostrando desde el 0 al 0 del total de  0 registros",
	             infoFiltered: "(Filtrados del total de _MAX_ registros)",
	             infoPostFix: "",
	             thousands: ",",
	             lengthMenu: "Mostrar _MENU_ registros por página",
	             loadingRecords: "Cargando...",
	             processing: "Procesando...",
	             search: "Buscar registro:",
	             zeroRecords: "No se han encontrado registros",
           paginate: {
             first: "Primera",
             last: "Última",
             next: "Siguiente",
             previous: "Anterior"
           },
           aria: {
             sortAscending: ": activate to sort column ascending",
             sortDescending: ": activate to sort column descending"
           }
         }
} );
});
</script>
<title></title>
</head>
<body>
<!-- Image and text -->
<nav class="navbar navbar-light bg-light">
  <a class="navbar-brand" href="#">
    <img src="Imagenes/Bancoicon.png" width="100" height="57" class="d-inline-block align-center" alt=""> &nbsp;Menu Principal
  </a>
  <a class="navbar-brand" data-toggle="modal" href="#" data-target="#ModalCerrarSession">
    <img src="Imagenes/UserLog.png" width="80" height="57" class=" align-right" alt="">&nbsp;<strong>Nombre De Usuario</strong>
  </a>
</nav>
<fieldset class="border p-1">
<legend  class="w-auto">Modificacion/Baja Cliente</legend>
	 <div class="container-fluid">
			  <div class="row row-cols-2">
				<div class="col-2">
				<fieldset class="border p-2">
				<legend  class="w-auto">Busqueda</legend>
				 <form class="form"  id="form-1" >
			      <div class="form-group "> <!-- DNI -->
			      <label for="full_name_id" class="control-label">Numero De Documento</label>
				        <input type="number" class="form-control form-control-sm" id="full_name_id" name="full_name" placeholder="D.N.I">
				    </div>  
				    <div class="form-group text-center" style="padding-left: 10px"> <!-- Submit Button -->
			         	<button type="submit" class="btn-sm btn-primary">Buscar</button>
			        </div>   
				</form>
				</fieldset>
				</div>
				<div class="col-10">
				<!-- inicio tabla -->
<fieldset class="border p-1">
<legend  class="w-auto">Clientes</legend>
	<table id="TClientes" class="table table-hover table-sm" style="padding-left: 5px">
	  <thead class="thead-dark">
	    <tr>
	      <th scope="col">DNI</th>
	      <th scope="col">Nombre</th>
	      <th scope="col">Apellido</th>
	      <th scope="col">E-mail</th>
	      <th scope="col">Editar</th>
	      <th scope="col">Estado</th>
	    </tr>
	  </thead>
	  <tbody>
	    <tr>
	      <td>12345678</td>
	      <td>Esteban</td>
	      <td>Arriaga</td>
	      <td>Estarrist@gmail.com</td>
	      <td><input type="submit" class="btn-sm btn-warning" name="BtnEditClie" value="Editar" data-toggle="modal" data-target="#ModalEditarCliente"/></td>
	      <td><input type="submit" class="btn-sm btn-primary" name="BtnBajaClie" value="Baja" data-toggle="modal" data-target="#ModalBajaCliente"/></td>
	    </tr>
	    <tr>
	      <td>23456789</td>
	      <td>Carlos</td>
	      <td>Gonzales</td>
	      <td>CcarlosGon@hotmail.com.ar</td>
	      <td><input type="submit" class="btn-sm btn-warning" name="BtnEditClie" value="Editar" data-toggle="modal" data-target="#ModalEditarCliente"/></td>
	      <td><input type="submit" class="btn-sm btn-primary" name="BtnBajaClie" value="Alta" data-toggle="modal" data-target="#ModalBajaCliente"/></td>
	    </tr>
	    <tr>
	      <td>34587962</td>
	      <td>Pedro</td>
	      <td>Lopez</td>
	      <td>Plopex@gmail.com</td>
	     <td><input type="submit" class="btn-sm btn-warning" name="BtnEditClie" value="Editar" data-toggle="modal" data-target="#ModalEditarCliente" /></td>
	     <td><input type="submit" class="btn-sm btn-primary" name="BtnBajaClie" value="Baja" data-toggle="modal" data-target="#ModalBajaCliente"/></td>
	    </tr>
	  </tbody>
	</table>
</fieldset>	   
<!--Fin Tabla-->
				</div>
			  </div>	
	</div>	
</fieldset>		

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
      <div class="modal-body">
        ¿Desea cerrar la sesion?
      </div>
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

<!-- modal Editar cliente  -->
<div class="modal fade" id="ModalEditarCliente" tabindex="-1" role="dialog">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Editar Cliente</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
	      <form action="">
	      	<div class="container-fluid">
	      	<div class="row">
			<div class="col-8 col-sm-6">
			
			 <div class="form-group"> <!-- DNI -->
		        <label for="full_name_id" class="control-label">Numero De Documento</label>
		        <input type="number" class="form-control form-control-sm" id="full_name_id" name="full_name" placeholder="D.N.I">
		    </div>  
		    <div class="form-group"> <!-- Nombre -->
		        <label for="full_name_id" class="control-label">Nombre</label>
		        <input type="text" class="form-control form-control-sm" id="full_name_id" name="full_name" placeholder="NOMBRE">
		    </div>    
		    <div class="form-group"> <!-- Apellido -->
		        <label for="full_name_id" class="control-label">Apellido</label>
		        <input type="text" class="form-control form-control-sm" id="full_name_id" name="full_name" placeholder="APELLIDO">
		    </div> 

		      <div class="form-group"> <!-- Correo electronico -->
		        <label for="full_name_id" class="control-label">Correo Electronico</label>
		        <input type="email" class="form-control form-control-sm" id="full_name_id" name="full_name" placeholder="e-mail" required>
		    </div> 
		    
		    <div class="form-group"> <!-- Telefono -->
		        <label for="full_name_id" class="control-label">Numero de telefono</label>
		        <input type="number" class="form-control form-control-sm" id="full_name_id" name="full_name" placeholder="Telefono">
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
			<div class="col-8 col-sm-6">
			<div class="form-group"> <!-- Nacionalidad -->
		        <label for="full_name_id" class="control-label">Nacionalidad</label>
		        <input type="text" class="form-control form-control-sm" id="full_name_id" name="full_name" placeholder="NACIONALIDAD">
		    </div> 
		     <div class="form-group "><!-- Fecha De Nacimiento -->
		     <label for="full_name_id" class="control-label">Fecha De Nacimiento</label>
			    <input class="form-control form-control-sm" type="date"  id="example-date-input">
			</div>
		   <div class="form-group"> <!-- Direccion -->
		        <label for="full_name_id" class="control-label">Direccion</label>
		        <input type="text" class="form-control form-control-sm" id="full_name_id" name="full_name" placeholder="DIRECCION">
		    </div>
		            
		    <div class="form-group"> <!-- Localidad -->
		        <label for="full_name_id" class="control-label">Localidad</label>
		        <input type="text" class="form-control form-control-sm" id="full_name_id" name="full_name" placeholder="LOCALIDAD">
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
		      
		</div>
		</div>
			</div>
	      </form>
      </div>
      <div class="modal-footer">
     <form action="#" method="post" accept-charset=utf-8>
     <button type="button" class="btn-sm btn-secondary" data-dismiss="modal">Cancelar</button>
	 <button type="Submit" class="btn-sm btn-success" name="BtnCerrarSesion" >Grabar</button>		
		</form>
      </div>
    </div>
  </div>
</div>  
<!-- modal Editar cliente  -->

<!-- modal Dar de baja cliente  -->
<div class="modal fade" id="ModalBajaCliente" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Confirmar Baja Cliente</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body text-center">
     <strong >¿Esta seguro que quiere dar de baja a este cliente?</strong>
      </div>
      <div class="modal-footer">
     <form action="#" method="post" accept-charset=utf-8>
     <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
	 <button type="Submit" class="btn btn-danger" name="BtnCerrarSesion" >Confirmar</button>		
		</form>
      </div>
    </div>
  </div>
</div>  
<!-- modal Dar de baja cliente  -->

</body>
</html>