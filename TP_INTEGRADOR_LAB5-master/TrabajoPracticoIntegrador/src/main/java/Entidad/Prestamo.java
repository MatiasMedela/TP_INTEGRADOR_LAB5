package Entidad;

import java.io.Serializable;

public class Prestamo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//Atributos
	private int id;
	private Usuario usuario;
	private Movimiento movimiento;
	private int cantidadMeses;
	private float importeTotal;
	private boolean autorizado;
	private float montoPagar;
	
	//Constructor
	public Prestamo()
	{
		
	}
	
	public Prestamo(int id,Usuario usuario,Movimiento movimiento,int cantidadMeses,float importeTotal,boolean autorizado,float montoPagar)
	{
		this.id = id;
		this.usuario =usuario;
		this.movimiento = movimiento;
		this.cantidadMeses = cantidadMeses;
		this.importeTotal = importeTotal;
		this.autorizado = autorizado;
		this.montoPagar = montoPagar;
	}
	
	public Prestamo(Usuario usuario,Movimiento movimiento,int cantidadMeses,float importeTotal,boolean autorizado,float montoPagar)
	{
		this.usuario =usuario;
		this.movimiento = movimiento;
		this.cantidadMeses = cantidadMeses;
		this.importeTotal = importeTotal;
		this.autorizado = autorizado;
		this.montoPagar = montoPagar;
	}

	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Movimiento getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

	public int getCantidadMeses() {
		return cantidadMeses;
	}

	public void setCantidadMeses(int cantidadMeses) {
		this.cantidadMeses = cantidadMeses;
	}

	public float getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(float importeTotal) {
		this.importeTotal = importeTotal;
	}

	public boolean isAutorizado() {
		return autorizado;
	}

	public void setAutorizado(boolean autorizado) {
		this.autorizado = autorizado;
	}

	public float getMontoPagar() {
		return montoPagar;
	}

	public void setMontoPagar(float montoPagar) {
		this.montoPagar = montoPagar;
	}
	
	
	
	//Métodos

}
