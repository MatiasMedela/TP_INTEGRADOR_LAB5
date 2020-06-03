package Entidad;

import java.io.Serializable;

public class Movimiento implements Serializable{

	private static final long serialVersionUID = 1L;
	//Atributos
	private int id;
	private Tipo_Movimiento tipoMovimiento;
	private String cbuOrigen;
	private String Fecha;
	private float importe;
	
	//Constructor
	public Movimiento()
	{
		
	}
	
	public Movimiento(int id,Tipo_Movimiento tipoMovimiento,String cbuOrigen,String fecha,float importe)
	{
		this.id = id;
		this.tipoMovimiento = tipoMovimiento;
		this.cbuOrigen = cbuOrigen;
		this.Fecha = fecha;
		this.importe = importe;
		
	}
	
	public Movimiento(Tipo_Movimiento tipoMovimiento,String cbuOrigen,String fecha,float importe)
	{

		this.tipoMovimiento = tipoMovimiento;
		this.cbuOrigen = cbuOrigen;
		this.Fecha = fecha;
		this.importe = importe;
	}
	
	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tipo_Movimiento getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(Tipo_Movimiento tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public String getCbuOrigen() {
		return cbuOrigen;
	}

	public void setCbuOrigen(String cbuOrigen) {
		this.cbuOrigen = cbuOrigen;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}
	

	//M�todos
}
