package Dominio;

import java.io.Serializable;

public class Tipo_Cuenta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//Atributos
	private int idTipoCuenta;
	private String descripcion;
	
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
	public int GetIdTipoCuenta()
	{
		return this.idTipoCuenta;
	}
	
	public void SetIdTipoCuenta(int id)
	{
		this.idTipoCuenta = id;
	}
	
	public String GetDescripcion()
	{
		return this.descripcion;
	}
	
	public void SetDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}
	
	//Métodos

}
