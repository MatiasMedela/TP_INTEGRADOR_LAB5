package Dominio;

import java.io.Serializable;

public class Tipo_Usuario implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	//Atributos
	private int idTipoUsuario;
	private String descripcion;
	
	//Constructores
	public Tipo_Usuario()
	{
		
	}
	
	public Tipo_Usuario(int id, String descripcion)
	{
		this.idTipoUsuario = id;
		this.descripcion = descripcion;
	}
	
	public Tipo_Usuario(String descripcion)
	{
		this.descripcion = descripcion;
	}
	
	//Getters and Setters
	public int GetIdTipoUsuario()
	{
		return this.idTipoUsuario;
	}
	
	public void SetIdTipoUsuario(int id)
	{
		this.idTipoUsuario = id;
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
