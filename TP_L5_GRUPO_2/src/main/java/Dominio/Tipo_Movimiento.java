package Dominio;

import java.io.Serializable;

public class Tipo_Movimiento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//Atributos
	private int idTipoMovimiento;
	private String descripcion;
	
	//Contstuctor
	public Tipo_Movimiento()
	{
		
	}
	
	public Tipo_Movimiento(int id, String descripcion)
	{
		this.idTipoMovimiento = id;
		this.descripcion = descripcion;
	}
	
	public Tipo_Movimiento(String descripcion)
	{
		this.descripcion = descripcion;
	}
	
	//Gettesr and Setters
	public int getIdTipoMovimiento()
	{
		return this.idTipoMovimiento;
	}
	
	public void setIdTipoMovimiento(int id)
	{
		this.idTipoMovimiento = id;
	}
	
	public String getDescripcion()
	{
		return this.descripcion;
	}
	
	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}
	
	//Métodos

}
