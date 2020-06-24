package Dominio;

import java.io.Serializable;

public class Logueo implements Serializable{

	private static final long serialVersionUID = 1L;
	//Atributos
	private int idLogueo;
	private String nUsuario;
	private String contrasenia;
	private Usuario usuario;
	
	//Constructor
	public Logueo()
	{
		
	}
	
	public Logueo(int id,String nUsuario,String contrasenia,Usuario usuario)
	{
		this.idLogueo = id;
		this.nUsuario = nUsuario;
		this.contrasenia = contrasenia;
		this.usuario = usuario;
	}
	
	public Logueo(String nUsuario,String contrasenia,Usuario usuario)
	{
		this.nUsuario = nUsuario;
		this.contrasenia = contrasenia;
		this.usuario = usuario;
	}
	
	//Getters and Setters
	public int getIdLogueo()
	{
		return this.idLogueo;
	}
	
	public void setIdLogueo(int id)
	{
		this.idLogueo = id;
	}
	
	public String getNUsuario()
	{
		return this.nUsuario;
	}
	
	public void setNUsuario(String nUsuario)
	{
		this.nUsuario = nUsuario;
	}
	
	public String getContrasenia()
	{
		return this.contrasenia;
	}
	
	public void setContrasenia(String contrasenia)
	{
		this.contrasenia = contrasenia;
	}
	
	public Usuario getUsuario()
	{
		return this.usuario;
	}
	
	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}
	
	//Métodos
}
