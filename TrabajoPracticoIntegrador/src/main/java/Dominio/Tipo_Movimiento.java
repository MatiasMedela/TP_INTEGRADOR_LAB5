package Dominio;

public class Tipo_Movimiento {
	
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
