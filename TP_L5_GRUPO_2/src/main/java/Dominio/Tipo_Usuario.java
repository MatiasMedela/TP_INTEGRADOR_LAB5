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
	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	//Métodos
	@Override
	public String toString() {
		return "Tipo_Usuario [idTipoUsuario=" + idTipoUsuario + ", descripcion=" + descripcion + "]";
	}



}
