package Dominio;

import java.io.Serializable;
import java.util.Date;


public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//Atributos
	private String IdUsu;
	private Tipo_Usuario TipoUsu;
	private String Dni;
	private String Nombre;
	private String Apellido;
	private Genero Gen;
	private Date FechaNac;
	private Localidad Loc;
	private String Direccion;
	private String E_Mail;
	private String Tel;
	private boolean Estado;
	
	//Constructor vacio
	public Usuario()
	{
		
	}
	//constructor por parametros
	public Usuario(String Legajo, Tipo_Usuario tipoUsuario,Genero genero,Localidad localidad,boolean estado,String nombre,
				  String apellido,Date fechaNacimiento,String direccion,String e_mail,String tel )
	{
		this.IdUsu=Legajo;
		this.TipoUsu = tipoUsuario;
		this.Gen = genero;
		this.Loc = localidad;
		this.Estado = estado;
		this.Nombre = nombre;
		this.Apellido = apellido;
		this.Dni = nombre;
		this.FechaNac = fechaNacimiento;
		this.Direccion = direccion;
		this.E_Mail = e_mail;
		this.Tel=tel;
	}
	
	//----comienzo getters and setters
	public String getIdUsu() {return IdUsu;}
	public void setIdUsu(String idUsu) {IdUsu = idUsu;}
	public Tipo_Usuario getTipoUsu() {return TipoUsu;}
	public void setTipoUsu(Tipo_Usuario tipoUsu) {TipoUsu = tipoUsu;}
	public String getDni() {return Dni;}
	public void setDni(String dni) {Dni = dni;}
	public String getNombre() {return Nombre;}
	public void setNombre(String nombre) {Nombre = nombre;}
	public String getApellido() {return Apellido;}
	public void setApellido(String apellido) {Apellido = apellido;}
	public Genero getGen() {return Gen;}
	public void setGen(Genero genero) {Gen = genero;}
	public Date getFechaNac() {return FechaNac;}
	public void setFechaNac(Date fechaNacimiento) {FechaNac = fechaNacimiento;}
	public Localidad getLocalidad() {return Loc;}
	public void setLocalidad(Localidad localidad) {Loc = localidad;}
	public String getDireccion() {return Direccion;}
	public void setDireccion(String direccion) {Direccion = direccion;}
	public String getE_Mail() {return E_Mail;}
	public void setE_Mail(String e_Mail) {E_Mail = e_Mail;}
	public boolean isEstado() {return Estado;}
	public void setEstado(boolean estado) {Estado = estado;}
	public String getTel() {return Tel;}
	public void setTel(String tel) {Tel = tel;}
	//----fin getters and setters
	
	//identificador de version
	public static long getSerialversionuid() {return serialVersionUID;}
//	@Override
//	public String toString() {
//		return "Usuario [IdUsu=" + IdUsu + ", TipoUsu=" + TipoUsu + ", Dni=" + Dni + ", Nombre=" + Nombre
//				+ ", Apellido=" + Apellido + ", Gen=" + Gen + ", FechaNac=" + FechaNac + ", Loc=" + Loc + ", Direccion="
//				+ Direccion + ", E_Mail=" + E_Mail + ", Tel=" + Tel + ", Estado=" + Estado + "]";
//	}
	
//Métodos

}
