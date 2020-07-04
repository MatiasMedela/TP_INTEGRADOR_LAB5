package Dominio;

import java.io.Serializable;
import java.util.Date;

public class Prestamo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//Atributos
	private int idPrestamo;
	private Usuario usuario;
	private Cuenta cbu;
	private Movimiento movimiento;
	private int cantidadMeses;
	private float importeTotal;
	private Date fechaSolicitud;
	private Date fechaResolucion;
	private EstadoPrestamo estado;
	private float montoPagar;
	
	//Constructor
	public Prestamo()
	{
		
	}
	
	public Prestamo(int id,Usuario usuario,Movimiento movimiento,int cantidadMeses,float importeTotal,EstadoPrestamo estado,float montoPagar, Cuenta cbu)
	{
		this.idPrestamo = id;
		this.usuario =usuario;
		this.movimiento = movimiento;
		this.cantidadMeses = cantidadMeses;
		this.importeTotal = importeTotal;
		this.estado = estado;
		this.montoPagar = montoPagar;
		this.cbu = cbu;
	}
	
	public Prestamo(Usuario usuario,Movimiento movimiento,int cantidadMeses,float importeTotal,EstadoPrestamo estado,float montoPagar, Cuenta cbu)
	{
		this.usuario =usuario;
		this.movimiento = movimiento;
		this.cantidadMeses = cantidadMeses;
		this.importeTotal = importeTotal;
		this.estado = estado;
		this.montoPagar = montoPagar;
		this.cbu = cbu;
	}
	

	public Cuenta getCbu() {
		return cbu;
	}

	public void setCbu(Cuenta cbu) {
		this.cbu = cbu;
	}

	//Getters and Setters
	public int getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(int id) {
		this.idPrestamo = id;
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

	public EstadoPrestamo getEstado() {
		return estado;
	}

	public void setEstado(EstadoPrestamo estado) {
		this.estado = estado;
	}

	public float getMontoPagar() {
		return montoPagar;
	}

	public void setMontoPagar(float montoPagar) {
		this.montoPagar = montoPagar;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Date getFechaResolucion() {
		return fechaResolucion;
	}

	public void setFechaResolucion(Date fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}
	
	
	//Métodos

}
