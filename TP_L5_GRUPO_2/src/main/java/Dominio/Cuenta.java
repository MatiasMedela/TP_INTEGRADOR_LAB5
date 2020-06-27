package Dominio;

import java.io.Serializable;
import java.util.Date;

public class Cuenta implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Atributos
	private int idCuenta;
	private Usuario usuario;
	private Date fechaCreacion;
	private Tipo_Cuenta tipoCuenta;
	private float saldo;
	private String cbu;
	private String alias;
	private boolean estado;
	
	//Constructor
	public Cuenta()
	{
		
	}
	
	public Cuenta(int id,Usuario usuario,Date fechaCreacion,Tipo_Cuenta tipoCuenta,float saldo,String cbu,String alias,boolean estado)
	{
		this.idCuenta = id;
		this.usuario = usuario;
		this.fechaCreacion = fechaCreacion;
		this.tipoCuenta = tipoCuenta;
		this.saldo = saldo;
		this.cbu=cbu;
		this.alias = alias;
		this.estado = estado;
	}
	
	public Cuenta(Usuario usuario,Date fechaCreacion,Tipo_Cuenta tipoCuenta,float saldo,String cbu,String alias,boolean estado)
	{
		this.usuario = usuario;
		this.fechaCreacion = fechaCreacion;
		this.tipoCuenta = tipoCuenta;
		this.saldo = saldo;
		this.cbu=cbu;
		this.alias = alias;
		this.estado = estado;
	}
	
	//Getters and Setters
	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int id) {
		this.idCuenta = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Tipo_Cuenta getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(Tipo_Cuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public String getCbu() {
		return cbu;
	}

	public void setCbu(String cbu) {
		this.cbu = cbu;
	}
	
	public String getAlias()
	{
		return this.alias;
	}
	
	public void setAlias(String alias)
	{
		this.alias = alias;
	}
	
	public boolean getEstado()
	{
		return this.estado;
	}
	
	public void setEstado(boolean estado)
	{
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Cuenta [idCuenta=" + idCuenta + ", usuario=" + usuario + ", fechaCreacion=" + fechaCreacion
				+ ", tipoCuenta=" + tipoCuenta + ", saldo=" + saldo + ", cbu=" + cbu + ", alias=" + alias + ", estado="
				+ estado + "]";
	}

	//M�todos
	
}
