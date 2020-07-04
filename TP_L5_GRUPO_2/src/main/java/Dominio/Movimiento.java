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
	private Cuenta cuentaOrigen;
	private Cuenta cuentaDestino;
	private Date fecha;
	private float importe;
	private String motivo;
	
	//Constructor
	public Movimiento()
	{
		
	}
	
	public Movimiento(int id,Tipo_Movimiento tipoMovimiento, Cuenta cuentaOrigen,Date fecha,float importe)
	{
		this.idMovimiento = id;
		this.tipoMovimiento = tipoMovimiento;
		this.cuentaOrigen = cuentaOrigen;
		this.fecha = fecha;
		this.importe = importe;
		
	}
	
	public Movimiento(Tipo_Movimiento tipoMovimiento,Cuenta cuentaOrigen,Date fecha,float importe)
	{

		this.tipoMovimiento = tipoMovimiento;
		this.cuentaOrigen = cuentaOrigen;
		this.fecha = fecha;
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

	public Cuenta getCuentaOrigen() {
		return cuentaOrigen;
	}

	public void setCuentaOrigen(Cuenta cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}

	public Cuenta getCuentaDestino() {
		return cuentaDestino;
	}

	public void setCuentaDestino(Cuenta cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
	
	public String getMotivo() {
		return motivo;
	}
	
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	//Métodos

}
