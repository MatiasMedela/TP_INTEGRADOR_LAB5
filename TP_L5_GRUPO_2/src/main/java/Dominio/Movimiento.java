package Dominio;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

public class Movimiento implements Serializable,PropertyEditorRegistrar{

	private static final long serialVersionUID = 1L;
	//Atributos
	private int idMovimiento;
	private Tipo_Movimiento tipoMovimiento;
	private double cbuOrigen;
	private Date Fecha;
	private float importe;
	
	//Constructor
	public Movimiento()
	{
		
	}
	
	public Movimiento(int id,Tipo_Movimiento tipoMovimiento,double cbuOrigen,Date fecha,float importe)
	{
		this.idMovimiento = id;
		this.tipoMovimiento = tipoMovimiento;
		this.cbuOrigen = cbuOrigen;
		this.Fecha = fecha;
		this.importe = importe;
		
	}
	
	public Movimiento(Tipo_Movimiento tipoMovimiento,double cbuOrigen,Date fecha,float importe)
	{

		this.tipoMovimiento = tipoMovimiento;
		this.cbuOrigen = cbuOrigen;
		this.Fecha = fecha;
		this.importe = importe;
	}
	
	//Getters and Setters
	public int getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(int id) {
		this.idMovimiento = id;
	}

	public Tipo_Movimiento getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(Tipo_Movimiento tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public double getCbuOrigen() {
		return cbuOrigen;
	}

	public void setCbuOrigen(double cbuOrigen) {
		this.cbuOrigen = cbuOrigen;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(Date.class, 
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
	}
	//Métodos
}
