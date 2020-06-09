package Dominio;

import java.io.Serializable;

public class Genero implements Serializable {

	private static final long serialVersionUID = 1L;
	//Atributos
	private int idGenero;
	private String descripcion;
	
	//Constructor
	public Genero()
	{
		
	}
	
	public Genero(int id, String descripcion)
	{
		this.idGenero = id;
		this.descripcion = descripcion;
	}
	
	public Genero(String descripcion)
	{
		this.descripcion = descripcion;
	}
	
	//Getters and Setters
	public int GetIdGenero() 
	{
		return this.idGenero;	
	}
	
	public void SetIdGenero(int id)
	{
		this.idGenero = id;
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
