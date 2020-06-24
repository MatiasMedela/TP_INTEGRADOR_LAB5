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
		this.idTipoCuenta = id;
		this.descripcion = descripcion;
	}
	
	public Tipo_Cuenta(String descripcion)
	{
		this.descripcion = descripcion;
	}
	
	//Getters and Setters
	public int getIdTipoCuenta()
	{
		return this.idTipoCuenta;
	}
	
	public void getIdTipoCuenta(int id)
	{
		this.idTipoCuenta = id;
	}
	
	public String getDescripcion()
	{
		return this.descripcion;
	}
	
	public void getDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	
	//Métodos
//	@Override
//	public String toString() {
//		return "Tipo_Cuenta [idTipoCuenta=" + idTipoCuenta + ", descripcion=" + descripcion + "]";
//	}

}
