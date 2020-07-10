<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, minimum-scale=1.0">
<meta charset="ISO-8859-1">
<!-- Jquery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Bootstrap CSS y Script -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" 
	crossorigin="anonymous">
	
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" 
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" 
	crossorigin="anonymous"></script>
	
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" 
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" 
	crossorigin="anonymous"></script>

<!-- Data Tables -->
	<script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap4.min.js"></script>
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"/>
	<link rel=stylesheet href="<c:url value="resources/Estilos/styles.css"/>" type="text/css" media=screen>
<!-- Sweet alert 2 -->
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
	
<script type="text/javascript">
$(document).ready(
		function() {
			$('#TClientes').DataTable(
				{
					"searching": true,
					"dom" : '<"pull-left"f><"pull-right"l>rt<"pull-left"i><"pull-right"p>',
					sPaginationType : "full_numbers",
					bProcessing : true,
					bAutoWidth : true,
					"lengthMenu": [[10,25, 50,100, -1], [10,25, 50,100, "All"]],
					language : {
						decimal : "",
						emptyTable : "No se han encontrado registros",
						infoEmpty : "Mostrando desde el 0 al 0 del total de  0 registros",
						infoFiltered : "(Filtrados del total de _MAX_ registros)",
						infoPostFix : "",
						thousands : ",",
						lengthMenu : "Mostrar _MENU_ registros por página",
						loadingRecords : "Cargando...",
						processing : "Procesando...",
						search : "Buscar registro:",
						zeroRecords : "No se han encontrado registros",
						info : "Mostrando desde el _START_ al _END_ del total de _TOTAL_ registros",
						paginate : {
							first : "Primera",
							last : "Última",
							next : "Siguiente",
							previous : "Anterior"
						},
						aria : {
							sortAscending : ": activate to sort column ascending",
							sortDescending : ": activate to sort column descending"
						}
					}
				});
					 });
					 
$(document).ready(function(){
	$('select#Prov_id').on('change',function(){
	    var valor = $(this).val();
		$("#Loc_id option").each(function(){
			var z=$(this).attr('value');
			var array = z.split(',');
			var g=array[1];
			if(array[1] == valor){
				$(this).show();
			}else{
				$(this).hide();
			}
		});
	});
})

function ValFormatoTelCel(){
	var TelTxt = document.querySelector('#TelEditId');
	TelTxt.disabled = false;
	TelTxt.setAttribute("placeholder", "ej: 1126208736");
	TelTxt.setAttribute("pattern", "/(\11)?[([0-9][ -]*){8}  ");
}

function ValFormatoTelFijo(){
	var TelTxt = document.querySelector('#TelEditId');
	TelTxt.disabled = false;
	TelTxt.setAttribute("placeholder", "ej: 0123489354");
	TelTxt.setAttribute("pattern", "/[0-9]{10}");
}

//con esta funcion pasamos los paremtros a los text del modal.
  function selCliente(Cadena){
	 var array=Cadena.split(",");
	 document.getElementById('DnieditId').value=array[0];
	 document.getElementById('IdOldDniName').value=array[0];
	 document.getElementById('NomEditId').value=array[1];
	 document.getElementById('ApeEditId').value=array[2];
	 //cmb genero
	  if (array[3] == "Masculino" ){
		  $("#GenEditId option[value=2]").attr("selected",true);
		   }else{
			   if(array[3]=="Femenino"){
				   $("#GenEditId option[value=1]").attr("selected",true);
				   }else{
					   $("#GenEditId  option[value=3]").attr("selected",true);
					}
		    }
	//cmb provincias
	    $("#Prov_id option").each(function(){
		    if(array[10]==$(this).text()){
		    	$("#Prov_id option[value="+$(this).attr('value')+"]").attr("selected",true);
			}
		});
	    //cmb localidades
	    $("#Loc_id option").each(function(){
		    if(array[5]== $(this).text()){
		    	$("#Loc_id option:contains("+array[5]+")").attr('selected', true);
			}
		});
	//Fecha nacimiento
	 var array2=array[4].split(" ");
	 document.getElementById('FnacEditId').value = array2[0];
	 document.getElementById('Dire_id').value=array[6];
	 document.getElementById('NacEditId').value=array[7];
	 document.getElementById('EmailEditId').value=array[8];
	 document.getElementById('TelEditId').value=array[9];
 };
 
 function PasarDniBaja(dni){
		var datos={
				"Dni":dni,	
			}
		Swal.fire({
			  title: '¿Esta seguro de dar de baja este cliente?',
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#d33',
			  cancelButtonText: "Cancelar",
			  reverseButtons: true,
			  cancelButtonColor: '#3085d6',
			  confirmButtonText: 'Baja',
			}).then((result) => {
			  if (result.value) {
				  $.ajax({
						type: "POST",
						url:'${request.getContextPath()}/TP_L5_GRUPO_2/DarDeBajaClienteAsync.html',
						data:datos,
						success:function(Res){
							if ( Res == "\"Valido\"") {
								Swal.fire(
									      'Cliente dado de baja exitosamente!',
										  'Cliente dado de baja.',
									      'success'
									    ).then(() =>{
											location.reload();									    	
									    })
								  } else {
									  Swal.fire({
										  icon: 'error',
										  title: 'Oops...',
										  text: 'Error del servidor',
										})
								 	}
							}
					});	
			     }
			})		
}

function PasarDniAlta(dni){
	 var datos={
				"Dni":dni,	
			}
		Swal.fire({
			  title: '¿Esta seguro de dar de alta este cliente?',
			  icon: 'warning',
			  showCancelButton: true,
			  cancelButtonText: "Cancelar",
			  reverseButtons: true,
			  confirmButtonColor: '#008000',
			  cancelButtonColor: '#3085d6',
			  confirmButtonText: 'Alta',
			}).then((result) => {
			  if (result.value) {
				  $.ajax({
						type: "POST",
						url:'${request.getContextPath()}/TP_L5_GRUPO_2/DarDeAltaClienteAsync.html',
						data:datos,
						success:function(Res){
							if ( Res == "\"Valido\"") {
								Swal.fire(
										  'Cliente dado de alta exitosamente!',
									      'Cliente dado de alta.',
									      'success'
									    )
								document.location.href = "/TP_L5_GRUPO_2/redirecNavBarAdmin.html?ListarClientes"
								  } else {
									  Swal.fire({
										  icon: 'error',
										  title: 'Oops...',
										  text: 'Error del servidor',
										})
								 	}
							}
					});	
			     }
			})		
}

function ModificarCliente(){
	var datos={
			"DniEditName":$("#DnieditId").val(),
			"OldDniName":$("#IdOldDniName").val(),
			"NomEditName":$("#NomEditId").val(),
			"ApeEditName":$("#ApeEditId").val(),
			"NacEditName":$("#NacEditId").val(),
			"EmailEditName":$("#EmailEditId").val(),
			"ProvEditName":$("#Prov_id").val(),
			"DirEditName":$("#Dire_id").val(),
			"FnacEditName":$("#FnacEditId").val(),
			"GenEditName":$("#GenEditId").val(),
			"LocEditName":$("#Loc_id").val(),
			"TelEditName":$("#TelEditId").val(),
		}
		$.ajax({
			type: "POST",
			url:'${request.getContextPath()}/TP_L5_GRUPO_2/ModificarClienteAsync.html',
			data:datos,
			success:function(Res){
				if ( Res == "\"Valido\"") {
						Swal.fire({
							title: 'Cliente modificado existosamente!',
							icon: 'success',
							showConfirmButton: true
						}).then((result) => {
							  if (result.value) {
								   location.reload();
								  }
								})
				 } else {
						 if(Res == "\"InvalidoDni\""){
							    document.getElementById('IdLabelDni').innerText = 'Numero de documento: invalido o ya esta registrado';
								document.getElementById("IdLabelDni").style.color="red";
								document.getElementById("DnieditId").style.border="1px solid red";
						  }else{
							  Swal.fire({
									title: 'Error al modificar cliente!',
									icon: 'error',
									showConfirmButton: true,
							  })
				  			}
				    }
			}
	     });
}
    </script>
<title></title>
</head>
<body>
	<!-- NAVBAR -->
	<%@ include file="NavbarAdmin.html"%>
	<!-- END NAVBAR -->
	<div class="container-fluid">
	<div class="row row-cols-2">
	<div class="col-12">
	<!-- inicio tabla -->
	<fieldset class="border p-1" >
	<legend class="w-auto">Clientes</legend>
	<table id="TClientes" class="table table-hover table-sm" style="padding-left: 5px">
	  <thead class="thead-dark">
	    <tr>
	      <th scope="col">DNI</th>
	      <th scope="col">Nombre y Apellido</th>
	      <th scope="col">Genero</th>
	      <th scope="col">Localidad</th>
	      <th scope="col">Provincia</th>
	      <th scope="col">Pais</th>
	      <th scope="col">E-mail</th>
	      <th scope="col">Telefono</th>
	      <th scope="col">Editar</th>
	      <th scope="col">Estado</th>
	    </tr>
	  </thead>
	  <tbody>
		  <c:forEach var="Cliente" items="${ ClientesList }">
		  <form action="ModificarCliente.html" method="get">
			 <tr id="Cliente-${ Cliente.getIdUsu() }">
				<td>${ Cliente.getDni() }</td>
				<td>${ Cliente.getNombre() }, ${ Cliente.getApellido() }</td>
				<td>${ Cliente.getGen().getDescripcion()}</td>
				<td>${ Cliente.getLoc().getLocNombre() }</td>
				<td>${ Cliente.getLoc().getProvLoc().getProvNombre() }</td>
				<td>${ Cliente.getNacionalidad() }</td>
				<td>${ Cliente.getEmail() }</td>
				<td>${ Cliente.getTel() }</td>
				<td class="text-center">
				<a href="#" style="border-radius: 1;border-color: white;text-align: center;" 
				name="BtnEditClie" data-toggle="modal" data-target="#ModalEditarCliente" 
				onclick="selCliente('${ Cliente.getDni()}'+','+'${ Cliente.getNombre()}'+','+'${ Cliente.getApellido()}'+','+'${ Cliente.getGen().getDescripcion()}'+','+'${ Cliente.getFechaNac()}'+','+'${ Cliente.getLoc().getLocNombre()}'+','+'${ Cliente.getDireccion()}'+','+'${ Cliente.getNacionalidad()}'+','+'${ Cliente.getEmail()}'+','+'${  Cliente.getTel()}'+','+'${ Cliente.getLoc().getProvLoc().getProvNombre() }');"> 
				<img 
				src="<c:url value="resources/Imagenes/edit.png"/>"
				width="18" height="18" alt="imagen editar">
				</a>
				</td>
		     	<td class="text-center">
					<c:choose>
					    <c:when test="${Cliente.isEstado()}">
						    <input type="submit" class="btn-sm btn-success btn-grid-action" name="BtnBajaClie" 
					     	value="Alta" data-toggle="modal" data-target="#ModalBajaCliente" onclick="PasarDniBaja(${ Cliente.getDni()})"/>
					    </c:when>    
					    <c:when test="${!Cliente.isEstado()}">
					       <input type="submit" class="btn-sm  btn-danger btn-grid-action" name="BtnAltaClie" 
		     				value="Baja" data-toggle="modal" data-target="#ModalAltaCliente" onclick="PasarDniAlta(${ Cliente.getDni()})"/>
					    </c:when>
					</c:choose>
		     	</td>
			 </tr>
		  </form>
		  </c:forEach>
	  </tbody>
	</table>
</fieldset>	   
<!--Fin Tabla-->
</div>
	</div>	
		</div>		

<!-- modal Editar cliente  -->
<div class="modal fade" id="ModalEditarCliente" tabindex="-1" role="dialog">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Editar cliente</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
	      <form action="ModificarCliente.html" method="get" id="ModificarClienteId">
	      	<div class="container-fluid">
	      	<div class="row">
			<div class="col-8 col-sm-6">
			 <div class="form-group"> <!-- DNI -->
		        <label for="full_name_id" class="control-label" id="IdLabelDni">Numero de documento</label>
		        <input type="number" class="form-control form-control-sm" id="DnieditId" name="DniEditName" placeholder="D.N.I" 
		        min="8" max="8" required>
		        <input type="hidden" class="form-control" name="OldDniName"id="IdOldDniName" value=""/>
		    </div>  
		    <div class="form-group"> <!-- Nombre -->
		        <label for="full_name_id" class="control-label">Nombre</label>
		        <input type="text" class="form-control form-control-sm" id="NomEditId" name="NomEditName" placeholder="NOMBRE" 
		        pattern="^[a-zA-Z ]*$" required>
		    </div>    
		    <div class="form-group"> <!-- Apellido -->
		        <label for="full_name_id" class="control-label">Apellido</label>
		        <input type="text" class="form-control form-control-sm" id="ApeEditId" name="ApeEditName" placeholder="APELLIDO" 
		        pattern="^[a-zA-Z ]*$" required>
		    </div> 

		      <div class="form-group"> <!-- Correo electronico -->
		        <label for="full_name_id" class="control-label">Correo electronico</label>
		        <input type="email" class="form-control form-control-sm" id="EmailEditId" name="EmailEditName" placeholder="e-mail"
				autocomplete="off" required>
		    </div> 
		    
		     <div class="form-group"><!-- Telefono -->
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
		        <input type="tel" class="form-control form-control-sm" id="TelEditId" name="TelEditName" placeholder="Telefono" 
		         title=" Respete el formato"  min="10" max="10"   pattern=""  disabled required >
		    </div>

		    
		     <div class="form-group"> <!-- Sexo -->
		        <label for="state_id" class="control-label">Sexo</label>
		        <select class="form-control form-control-sm" id="GenEditId" name="GenEditName">
		           <option value="1">Femenino</option>
		            <option value="2">Masculino</option>
		            <option value="3">Otro</option>
		        </select>                    
		    </div>
		    
			</div>
			<div class="col-8 col-sm-6">
			<div class="form-group"> <!-- Nacionalidad -->
		        <label for="full_name_id" class="control-label">Nacionalidad</label>
		        <input type="text" class="form-control form-control-sm" id="NacEditId" name="NacEditName" placeholder="NACIONALIDAD" 
		        pattern="^[a-zA-Z ]*$" required>
		    </div> 
		     <div class="form-group "><!-- Fecha De Nacimiento -->
		     <label for="full_name_id" class="control-label">Fecha de nacimiento</label>
			    <input class="form-control form-control-sm" type="date"  id="FnacEditId" name="FnacEditName" required>
			</div>
		            
		    <div class="form-group"> <!-- Provincia -->
		        <label for="state_id" class="control-label">Provincia</label>
		        <select class="form-control form-control-sm" id="Prov_id" name="ProvEditName" required>
		        	<option value="-1" selected disabled>--Provincia--</option> 
		            <option value="2">Buenos Aires</option>
		            <option value="1">Ciudad Autonoma De Buenos Aires</option>
		            <option value="15">Tucuman</option>
		            <option value="6">Entre Rios</option>
		            <option value="19">Misiones</option>
		            <option value="18">Formosa</option>
		            <option value="5">Corrientes</option>
		            <option value="13">Santa Fe</option>
		            <option value="4">Cordoba</option>
		            <option value="7">Jujuy</option>
		            <option value="17">Chubut</option>
		            <option value="24">Tierra Del Fuego</option>
		            <option value="20">Neuquen</option>
		            <option value="16">Chaco</option>
		            <option value="11">San Juan</option>
		            <option value="12">San Luis</option>
		            <option value="21">La Pampa</option>
		            <option value="23">Santa Cruz</option>
		            <option value="22">Rio Negro</option>
		            <option value="10">Salta</option>
		            <option value="3">Catamarca</option>
		            <option value="9">La Rioja</option>
		            <option value="14">Santiago Del Estero</option>
		            <option value="8">Mendoza</option>
		        </select>                    
		    </div> 
		   
		   <div class="form-group"> <!-- Localidad -->
		      <label for="state_id" class="control-label">Localidad</label>
		      <select class="form-control form-control-sm" id="Loc_id" name="LocEditName" required> 
		      <option value="-1" selected disabled>--Localidad--</option> 
		      <c:forEach items="${LocalidadesList}" var="loc" varStatus="loop">
						  <option value="${loc.getIdLocalidad()},${loc.getProvLoc().getIdProvincia() }">${loc.getLocNombre()}</option>
		      </c:forEach>
			  </select>                     
		    </div>      
		    
		    <div class="form-group"> <!-- Direccion -->
		        <label for="full_name_id" class="control-label">Direccion</label>
		        <input type="text" class="form-control form-control-sm" id="Dire_id" name="DirEditName" 
		        placeholder="DIRECCION" autocomplete="off"  required>
		    </div> 
		      
		</div>
	</div>
</div>
 	<div class="modal-footer">
	     <button type="button" class="btn-sm btn-secondary" data-dismiss="modal">Cancelar</button>
		 <button type="button" class="btn-sm btn-success" name="BtnGrabar" onclick="return ModificarCliente()">Grabar</button>		
      </div>
      </form>
      </div>
    </div>
  </div>
</div>  
<!-- fin modal Editar cliente  -->
</body>
</html>