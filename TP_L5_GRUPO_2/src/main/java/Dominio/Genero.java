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
	public int getIdGenero() 
	{
		return this.idGenero;	
	}
	
	public void setIdGenero(int id)
	{
		this.idGenero = id;
	}
	
	public String getDescripcion()
	{
		return this.descripcion;
	}
	
	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}
	
	//Métodos
	public void InitGenero() {
		
	}
	public void DestroyGenero() {
			
	}

	@Override
	public String toString() {
		return "Genero [idGenero=" + idGenero + ", descripcion=" + descripcion + "]";
	}
		
}
