package Dominio;

public class Genero {

	//Atributos
	private int id;
	private String descripcion;
	
	//Constructor
	public Genero()
	{
		
	}
	
	public Genero(int id, String descripcion)
	{
		this.id = id;
		this.descripcion = descripcion;
	}
	
	public Genero(String descripcion)
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
