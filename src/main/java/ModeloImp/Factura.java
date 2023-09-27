package ModeloImp;

import java.sql.Date;

public class Factura {
	
	private String nombre;
	private String conceptoConsumo;
	private Date fecha;
	private double valor;
	
	public Factura() {
		this.setFecha(new Date(System.currentTimeMillis()));
		
	}
	
	public Factura(String nombre, String conceptoConsumo, double valor) {
		this.nombre = nombre;
		this.conceptoConsumo = conceptoConsumo;		
		this.valor = valor;
		this.setFecha(new Date(System.currentTimeMillis()));
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getConceptoConsumo() {
		return conceptoConsumo;
	}

	public void setConceptoConsumo(String conceptoConsumo) {
		this.conceptoConsumo = conceptoConsumo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String mostrarFactura() {
		return "\nNombre: " 	+ this.nombre
			  +"\nConcepto: " + this.conceptoConsumo
			  +"\nFecha: " 	+ this.fecha.toString()
			  +"\nValor: " 	+ this.valor;
	}
	
}
