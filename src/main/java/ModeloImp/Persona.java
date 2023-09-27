package ModeloImp;

import java.util.ArrayList;

public class Persona {
	
	private int cedula;
	private String nombre;
	private ArrayList<Factura> facturas;
	
	public Persona() {
		facturas = new ArrayList<Factura>();
	}

	public Persona(int cedula, String nombre) {
		this.cedula = cedula;
		this.nombre = nombre;
		facturas = new ArrayList<Factura>();
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Factura getFactura(int posicion) {
		return facturas.get(posicion);
	}

	public void setFactura(Factura factura) {
		this.facturas.add(factura);
	}

	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}
	
	public String mostrarFacturas() {
		String facturasAlmacenadas = "";
		for(int i = 0; i < this.facturas.size(); i++) {
			facturasAlmacenadas += "\n-----------------";
			facturasAlmacenadas += "\nFactura #" + (i+1);
			facturasAlmacenadas += "\n_________________";
			facturasAlmacenadas += this.facturas.get(i).mostrarFactura();
		}
		return facturasAlmacenadas;
	}
	
}
