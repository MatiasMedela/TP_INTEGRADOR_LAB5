package Dominio;

import java.io.Serializable;

public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//Atributos
	private String Legajo;
	private Tipo_Usuario tipoUsuario;
	private Genero genero;
	private Localidad localidad;
	private boolean estado;
	private String nombre;
	private String apellido;
	private String fechaNacimiento;
	private String direccion;
	private String e_mail;
	
	//Constructor
	public Usuario()
	{
		
	}
	
	public Usuario(String Legajo, Tipo_Usuario tipoUsuario,Genero genero,Localidad localidad,boolean estado,String nombre,
				  String apellido,String fechaNacimiento,String direccion,String e_mail)
	{
		this.Legajo=Legajo;
		this.tipoUsuario = tipoUsuario;
		this.genero = genero;
		this.localidad = localidad;
		this.estado = estado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.e_mail = e_mail;
	}
	
	public Usuario(Tipo_Usuario tipoUsuario,Genero genero,Localidad localidad,boolean estado,String nombre,
			  String apellido,String fechaNacimiento,String direccion,String e_mail)
	{
	
		this.tipoUsuario = tipoUsuario;
	
		this.genero = genero;
		this.localidad = localidad;
		this.estado = estado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.e_mail = e_mail;
	}

	//Getters and Setters
	public String getLegajo() {
		return this.Legajo;
	}

	public void setLegajo(String Legajo) {
		this.Legajo = Legajo;
	}

	public Tipo_Usuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(Tipo_Usuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	
	//Métodos

}
