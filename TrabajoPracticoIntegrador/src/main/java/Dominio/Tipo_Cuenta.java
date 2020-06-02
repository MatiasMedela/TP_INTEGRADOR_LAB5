package Dominio;

public class Tipo_Cuenta {
	
	//Atributos
	private int id;
	private String descripcion;
	
	//Constructor
	public Tipo_Cuenta()
	{
		
	}
	
	public Tipo_Cuenta(int id, String descripcion)
	{
		this.id = id;
		this.descripcion = descripcion;
	}
	
	public Tipo_Cuenta(String descripcion)
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
