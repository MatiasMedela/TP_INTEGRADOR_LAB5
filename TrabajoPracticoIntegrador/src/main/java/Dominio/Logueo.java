package Dominio;

import java.io.Serializable;

public class Logueo implements Serializable{

	private static final long serialVersionUID = 1L;
	//Atributos
	private String id;
	private String nUsuario;
	private String contrasenia;
	private Usuario usuario;
	
	//Constructor
	public Logueo()
	{
		
	}
	
	public Logueo(String id,String nUsuario,String contrasenia,Usuario usuario)
	{
		this.id = id;
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
	public String GetId()
	{
		return this.id;
	}
	
	public void SetId(String id)
	{
		this.id = id;
	}
	
	public String GetNUsuario()
	{
		return this.nUsuario;
	}
	
	public void SetNUsuario(String nUsuario)
	{
		this.nUsuario = nUsuario;
	}
	
	public String GetContrasenia()
	{
		return this.contrasenia;
	}
	
	public void SetContrasenia(String contrasenia)
	{
		this.contrasenia = contrasenia;
	}
	
	public Usuario GetUsuario()
	{
		return this.usuario;
	}
	
	public void SetUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}
	
	//Métodos
}
