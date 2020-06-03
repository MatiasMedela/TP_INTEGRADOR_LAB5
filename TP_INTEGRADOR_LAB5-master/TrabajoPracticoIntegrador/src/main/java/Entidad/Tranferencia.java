package Entidad;

import java.io.Serializable;

public class Tranferencia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//Atributos
	private int id;
	private Movimiento movimiento;
	private String cbuDestino;
	
	//Constructor
	public Tranferencia()
	{
		
	}
	
	public Tranferencia(int id,Movimiento movimiento,String cbuDestino)
	{
		this.id = id;
		this.movimiento = movimiento;
		this.cbuDestino= cbuDestino;
	}
	
	public Tranferencia(Movimiento movimiento,String cbuDestino)
	{
		this.movimiento = movimiento;
		this.cbuDestino= cbuDestino;
	}

	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Movimiento getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}

	public String getCbuDestino() {
		return cbuDestino;
	}

	public void setCbuDestino(String cbuDestino) {
		this.cbuDestino = cbuDestino;
	}
	
	
}
