package Dominio;

import java.io.Serializable;

public class Transferencia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//Atributos
	private int idTransferencia;
	private Movimiento movimiento;
	private double cbuDestino;
	
	//Constructor
	public Transferencia()
	{
		
	}
	
	public Transferencia(int id,Movimiento movimiento,double cbuDestino)
	{
		this.idTransferencia = id;
		this.movimiento = movimiento;
		this.cbuDestino= cbuDestino;
	}
	
	public Transferencia(Movimiento movimiento,double cbuDestino)
	{
		this.movimiento = movimiento;
		this.cbuDestino= cbuDestino;
	}

	//Getters and Setters
	public int getIdTransferencia() {
		return idTransferencia;
	}

	public void setIdTransferencia(int id) {
		this.idTransferencia = id;
	}

	public Movimiento getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

	public double getCbuDestino() {
		return cbuDestino;
	}

	public void setCbuDestino(double cbuDestino) {
		this.cbuDestino = cbuDestino;
	}
	
	
}
