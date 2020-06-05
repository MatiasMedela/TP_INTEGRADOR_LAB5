<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<link rel=StyleSheet href="styles.css" type="text/css" media=screen>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">
    <img src="https://toppng.com/uploads/preview/indian-bank-icon-bank-sign-icon-11553435301aafxlgwngt.png" width="35" height="35" alt="" loading="lazy">
  </a>
<!-- NAVBAR -->
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Inicio</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Transferencias</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Préstamos</a>
      </li>
    </ul>
      <ul class="navbar-nav ml-auto">
         <li class="nav-item dropdown">
	     <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	       Cuenta
	     </a>
	     <div class="dropdown-menu" aria-labelledby="navbarDropdown">
	       <a class="dropdown-item" href="#">Configuración</a>
	       <a class="dropdown-item" href="#">Salir</a>
    	 </div>
   	</li>
    </ul>
   </div>
</nav>
<!-- END NAVBAR -->

<!-- CONTENT -->

<div class="container-md">
<h3 style="margin-top: 20px;" >Mis cuentas</h3>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Tipo de cuenta</th>
      <th scope="col">Identificación</th>
      <th scope="col">Moneda</th>
      <th scope="col">Saldo</th>
      <th scope="col" style="text-align:center;">Detalle</th>
      <th scope="col" style="text-align:center;">Movimientos</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>Caja ahorro en pesos</td>
      <td>Cuenta principal</td>
      <td>Pesos</td>
      <td>$10.000</td>
      <td><button type="button" class="btn btn-grid btn-light" data-toggle="modal" data-target="#ModalDetails">Ver detalles</button></td>
      <td><button type="button" class="btn btn-grid btn-light" data-toggle="modal" data-target="#ModalMovements">Ver movimientos</button></td>
    </tr>
    <tr>
      <td>Caja ahorro en dólares</td>
      <td>Cuenta principal usd</td>
      <td>Dólares</td>
      <td>$200</td>
      <td><button type="button" class="btn btn-grid btn-light" data-toggle="modal" data-target="#ModalDetails">Ver detalles</button></td>
      <td><button type="button" class="btn btn-grid btn-light" data-toggle="modal" data-target="#ModalMovements">Ver movimientos</button></td>
    </tr>
    <tr>
      <td>Cuenta corriente</td>
      <td>Cuenta secundaria</td>
      <td>Pesos</td>
      <td>$350.000</td>
      <td><button type="button" class="btn btn-grid btn-light" data-toggle="modal" data-target="#ModalDetails">Ver detalles</button></td>
      <td><button type="button" class="btn btn-grid btn-light" data-toggle="modal" data-target="#ModalMovements">Ver movimientos</button></td>
    </tr>
  </tbody>
</table>

</div>

<!-- END CONTENT -->

<!-- MODAL DETAILS -->
<div class="modal fade" id="ModalDetails" tabindex="-1" role="dialog" aria-labelledby="ModalDetailsAccount" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Detalle de cuenta</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      	<div class="row">
      		<div class="col-4" style="text-align:right;">
    		  <p>Tipo de cuenta:</p>
	          <p>Identificación:</p>
	          <p>Moneda:</p>
	          <p>CBU:</p>
	          <p>ALIAS CBU:</p>
	          <p>Saldo:</p>
      		</div>
      		<div class="col-8">
    		  <p>Caja ahorro en pesos</p>
    		        	<div class="row">
    		  <div class="col-8">
	          <p id="text-ident">Cuenta principal</p>
	          <input id="input-ident" type="text" class="form-control form-detalle" value="Cuenta principal" hidden>
	          </div>
	          <div class="col-4">
	          <p class="edit-text" id="edit-ident">Editar</p>
	          </div>
	          </div>
	          <p>Pesos</p>
       		  <div class="row">
    		  <div class="col-8">
	          <p>0000000000000000000000</p>
	          </div>
   	          <div class="col-4">
	          <p class="edit-text" id="edit-ident">Copiar</p>
	          </div>
	          </div>
	          <p>WORD.WORD.WORD</p>
	          <p>$10.000</p>
      		</div>
          </div>
      	</div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" disabled>Guardar cambios</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
      </div>
    </div>
  </div>
</div>
<!-- END MODAL DETAILS -->

<!-- MODAL DETAILS -->
<div class="modal fade" id="ModalMovements" tabindex="-1" role="dialog" aria-labelledby="ModalMovementsAccount" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Movimientos - Cuenta principal</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <table class="table tableMovements">
  <thead>
    <tr>
      <th scope="col">Fecha</th>
      <th scope="col">Tipo</th>
      <th scope="col">Descripción</th>
      <th scope="col">Importe</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>4/6/2020</td>
      <td>Crédito</td>
      <td>CBU Origen: 0000000000000000000001</td>
      <td>$35.000</td>
    </tr>
    <tr>
      <td>2/6/2020</td>
      <td>Débito</td>
      <td>CBU Destino: 0000000000000000000002</td>
      <td>$12.000</td>
    </tr>
    <tr>
      <td>30/5/2020</td>
      <td>Débito</td>
      <td>CBU Destino: 0000000000000000000002</td>
      <td>$2.500</td>
    </tr>
  </tbody>
</table>
      	</div>
    </div>
  </div>
</div>
<!-- END MODAL DETAILS -->

</body>

<script type="text/javascript">
	$('#edit-ident').click(function(){
		if($('#edit-ident').html() == "Editar"){
			$('#text-ident').attr('hidden', true);
			$('#input-ident').attr('hidden', false);
			$('#edit-ident').html('Aceptar');
		}
		else {
			$('#text-ident').attr('hidden', false);
			$('#input-ident').attr('hidden', true);
			$('#edit-ident').html('Editar');
		}
	})
</script>
</html>


