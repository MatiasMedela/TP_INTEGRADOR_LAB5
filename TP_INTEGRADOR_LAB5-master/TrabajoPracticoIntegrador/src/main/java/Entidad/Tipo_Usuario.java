package Entidad;

import java.io.Serializable;

public class Tipo_Usuario implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	//Atributos
	private int id;
	private String descripcion;
	
	//Constructores
	public Tipo_Usuario()
	{
		
	}
	
	public Tipo_Usuario(int id, String descripcion)
	{
		this.id = id;
		this.descripcion = descripcion;
	}
	
	public Tipo_Usuario(String descripcion)
	{
		this.descripcion = descripcion;
	}
	
	//Getters and Setters
	public int GetId()
	{
		return this.id;
	}
	
	public void SetId(int id)
	{
		this.id = id;
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
