package Dominio;

import java.io.Serializable;
import java.util.Date;

public class Cuota implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//Atributos
	private int numeroCuota;
	private Prestamo prestamo;
	private Date fechaVencimiento;
	private Date fechaPago;
	private Movimiento movimiento;
	private boolean pagada;
	
	//Constructor
	public Cuota()
	{
		
	}
	
	public Cuota(int numeroCuota,Prestamo prestamo,Movimiento movimiento)
	{
		this.numeroCuota = numeroCuota;
		this.prestamo = prestamo;
		this.movimiento = movimiento;
	}
	
	public Cuota(Prestamo prestamo,Movimiento movimiento)
	{
		this.prestamo = prestamo;
		this.movimiento = movimiento;
	}

	//Getters and Setters
	public int getNumeroCuota() {
		return numeroCuota;
	}

	public void setNumeroCuota(int numeroCuota) {
		this.numeroCuota = numeroCuota;
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	public Movimiento getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public boolean isPagada() {
		return pagada;
	}

	public void setPagada(boolean pagada) {
		this.pagada = pagada;
	}
	
	

}
