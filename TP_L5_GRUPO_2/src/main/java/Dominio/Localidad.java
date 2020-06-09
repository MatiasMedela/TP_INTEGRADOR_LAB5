package Dominio;

import java.io.Serializable;

public class Localidad implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Atributos
	private int idLocalidad;
	private Provincia provincia;
	private String descripcion;
	private String codigoPostal;
	
	//Constructor
	public Localidad()
	{
		
	}
	
	public Localidad(int id,Provincia provincia,String descripcion,String codigoPostal)
	{
		this.idLocalidad = id;
		this.provincia = provincia;
		this.descripcion = descripcion;
		this.codigoPostal = codigoPostal;
	}
	
	public Localidad(Provincia provincia,String descripcion,String codigoPostal)
	{
		this.provincia = provincia;
		this.descripcion = descripcion;
		this.codigoPostal = codigoPostal;
	}
	
	//Getters and Setters
	public int GetIdLocalidad()
	{
		return this.idLocalidad;
	}
	
	public void SetIdLocalidad(int id)
	{
		this.idLocalidad = id;
	}
	
	public Provincia GetProvincia()
	{
		return this.provincia;
	}
	
	public void SetProvincia(Provincia provincia)
	{
		this.provincia = provincia;
	}
	
	public String GetDescripcion()
	{
		return this.descripcion;
	}
	
	public void SetDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}
	
	public String GetCodigoPostal()
	{
		return this.codigoPostal;
	}
	
	public void SetCodigoPostal(String codigoPostal)
	{
		this.codigoPostal = codigoPostal;
	}
	
	//Métodos
}
