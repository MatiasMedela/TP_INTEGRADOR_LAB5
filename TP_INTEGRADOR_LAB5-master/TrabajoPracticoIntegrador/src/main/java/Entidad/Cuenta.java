package Entidad;

import java.io.Serializable;

public class Cuenta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//Atributos
	private int id;
	private Usuario usuario;
	private String fechaCreacion;
	private Tipo_Cuenta tipoCuenta;
	private float saldo;
	private String cbu;
	private boolean estado;
	
	//Constructor
	public Cuenta()
	{
		
	}
	
	public Cuenta(int id,Usuario usuario,String fechaCreacion,Tipo_Cuenta tipoCuenta,float saldo,String cbu,boolean estado)
	{
		this.id = id;
		this.usuario = usuario;
		this.fechaCreacion = fechaCreacion;
		this.tipoCuenta = tipoCuenta;
		this.saldo = saldo;
		this.cbu=cbu;
		this.estado = estado;
	}
	
	public Cuenta(Usuario usuario,String fechaCreacion,Tipo_Cuenta tipoCuenta,float saldo,String cbu,boolean estado)
	{
		this.usuario = usuario;
		this.fechaCreacion = fechaCreacion;
		this.tipoCuenta = tipoCuenta;
		this.saldo = saldo;
		this.cbu=cbu;
		this.estado = estado;
	}
	
	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
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
	
	public boolean GetEstado()
	{
		return this.estado;
	}
	
	public void SetEstado(boolean estado)
	{
		this.estado = estado;
	}

	//Métodos
}
