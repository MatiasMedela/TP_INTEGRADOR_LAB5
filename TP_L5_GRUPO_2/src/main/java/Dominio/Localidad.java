package Dominio;

import java.io.Serializable;

public class Localidad implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Atributos
	private int IdLocalidad;
	private String LocNombre;
	private String CodigoPostal;
	private Provincia ProvLoc;
	
	//Constructor vacio
	public Localidad()
	{
		
	}
	//constructor por parametros
	public Localidad(int id,Provincia provincia,String descripcion,String codigoPostal)
	{
		this.IdLocalidad = id;
		this.ProvLoc = provincia;
		this.LocNombre = descripcion;
		this.CodigoPostal = codigoPostal;
	}
	//Getters and Setters
	public int getIdLocalidad() {return IdLocalidad;}
	public void setIdLocalidad(int idLocalidad) {IdLocalidad = idLocalidad;}
	public String getLocNombre() {return LocNombre;}
	public void setLocNombre(String locNombre) {LocNombre = locNombre;}
	public String getCodigoPostal() {return CodigoPostal;}
	public void setCodigoPostal(String codigoPostal) {this.CodigoPostal = codigoPostal;}
	public Provincia getProvLoc() {return ProvLoc;}
	public void setProvLoc(Provincia provincia) {this.ProvLoc = provincia;}
	public static long getSerialversionuid() {return serialVersionUID;}
	//Métodos
	@Override
	public String toString() {
		return "Localidad [IdLocalidad=" + IdLocalidad + ", LocNombre=" + LocNombre + ", codigoPostal=" + CodigoPostal
				+ ", provincia=" + ProvLoc.getProvNombre() + "]";
	}
}
