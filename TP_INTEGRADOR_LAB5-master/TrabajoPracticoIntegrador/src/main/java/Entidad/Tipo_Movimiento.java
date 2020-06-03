package Entidad;

import java.io.Serializable;

public class Tipo_Movimiento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//Atributos
	private int id;
	private String descripcion;
	
	//Contstuctor
	public Tipo_Movimiento()
	{
		
	}
	
	public Tipo_Movimiento(int id, String descripcion)
	{
		this.id = id;
		this.descripcion = descripcion;
	}
	
	public Tipo_Movimiento(String descripcion)
	{
		this.descripcion = descripcion;
	}
	
	//Gettesr and Setters
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
