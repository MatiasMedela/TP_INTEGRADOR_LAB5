package Dominio;

import java.io.Serializable;

public class Provincia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Atributos
	private int id;
	private String descripcion;
	private String codigo;
	
	//Constructores
	public Provincia()
	{
		
	}
	
	public Provincia(int id, String descripcion, String codigo)
	{
		this.id = id;
		this.descripcion = descripcion;
		this.codigo = codigo;
	}
	
	public Provincia(String descripcion, String codigo)
	{
		this.descripcion = descripcion;
		this.codigo = codigo;
	}
	
	//Getters and Setters
	public int Getid()
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
	
	public String GetCodigo()
	{
		return this.codigo;
	}
	
	public void SetCodigo(String codigo)
	{
		this.codigo = codigo;
	}
	
	//Métodos
	
}
