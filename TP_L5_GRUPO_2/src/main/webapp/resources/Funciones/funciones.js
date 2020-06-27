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