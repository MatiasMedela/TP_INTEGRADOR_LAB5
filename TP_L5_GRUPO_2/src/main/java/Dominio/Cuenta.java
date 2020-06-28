package Dominio;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

public class Cuenta implements Serializable, PropertyEditorRegistrar{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Atributos
	private int idCuenta;
	private Usuario usuario;
	private Date fechaCreacion;
	private Tipo_Cuenta tipoCuenta;
	private float saldo;
	private double cbu;
	private String alias;
	private boolean estado;
	
	//Constructor
	public Cuenta()
	{
		
	}
	
	public Cuenta(int id,Usuario usuario,Date fechaCreacion,Tipo_Cuenta tipoCuenta,float saldo,double cbu,String alias,boolean estado)
	{
		this.idCuenta = id;
		this.usuario = usuario;
		this.setfechaCreacion(fechaCreacion);
		this.tipoCuenta = tipoCuenta;
		this.saldo = saldo;
		this.cbu=cbu;
		this.alias = alias;
		this.estado = estado;
	}
	
	public Cuenta(Usuario usuario,Date fechaCreacion,Tipo_Cuenta tipoCuenta,float saldo,double cbu,String alias,boolean estado)
	{
		this.usuario = usuario;
		this.setfechaCreacion(fechaCreacion);
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

	public double getCbu() {
		return cbu;
	}

	public void setCbu(double cbu) {
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

	public Date getfechaCreacion() {
		return fechaCreacion;
	}

	public void setfechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(Date.class, 
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));	
	}


	//Métodos
	
}
