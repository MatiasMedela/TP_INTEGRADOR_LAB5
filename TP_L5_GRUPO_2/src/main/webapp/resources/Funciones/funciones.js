function cantidadPaginas(){		
		var screenH = window.innerHeight;
		if(screenH < 615){
			$('.table').DataTable().page.len(5).draw();
		}
		else if(screenH < 680){
			$('.table').DataTable().page.len(6).draw();
		}
		else if(screenH < 740){
			$('.table').DataTable().page.len(7).draw();
		}
		else{
			$('.table').DataTable().page.len(8).draw();
		}
}

function soloNumeros(event) {
    var charCode = (event.which) ? event.which : event.keyCode
    if(charCode == 46){
    	return true;
    }
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
};
