package Dominio;

import java.io.Serializable;

public class Tipo_Cuenta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//Atributos
	private int idTipoCuenta;
	private String descripcion;
	private String moneda;


	//Constructor
	public Tipo_Cuenta()
	{
		
	}
	
	public Tipo_Cuenta(int id, String descripcion)
	{
		this.setIdTipoCuenta(id);
		this.setDescripcion(descripcion);
	}
	
	public Tipo_Cuenta(String descripcion)
	{
		this.setDescripcion(descripcion);
	}
	
	//Getters and Setters
	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdTipoCuenta() {
		return idTipoCuenta;
	}

	public void setIdTipoCuenta(int idTipoCuenta) {
		this.idTipoCuenta = idTipoCuenta;
	}

	@Override
	public String toString() {
		return "Tipo_Cuenta [idTipoCuenta=" + idTipoCuenta + ", descripcion=" + descripcion + ", moneda=" + moneda
				+ "]";
	}
}
