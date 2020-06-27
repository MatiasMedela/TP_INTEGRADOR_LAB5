package Dominio;

import java.io.Serializable;

public class Provincia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Atributos
	private int IdProvincia;
	private String ProvNombre;
	private String Codigo;
	
	//Constructores
	public Provincia()
	{
	}
	
	public Provincia(int id, String descripcion)
	{
		this.IdProvincia = id;
		this.ProvNombre = descripcion;
		
	}
	//Getters and Setters
	public int getIdProvincia() {return IdProvincia;}
	public void setIdProvincia(int idProvincia) {this.IdProvincia = idProvincia;}
	public String getProvNombre() {return ProvNombre;}
	public void setProvNombre(String provNombre) {ProvNombre = provNombre;}
	public static long getSerialversionuid() {return serialVersionUID;}
	public void setCodigo(String codigo) {Codigo = codigo;}
	public String getCodigo() {return Codigo;}
	//Métodos

	@Override
	public String toString() {
		return "Provincia [IdProvincia=" + IdProvincia + ", ProvNombre=" + ProvNombre + ", Codigo=" + Codigo + "]";
	}
	
}
