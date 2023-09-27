package ModeloImp;

import java.util.ArrayList;

public class Socio extends Persona {

	private double fondos;
	private String tipoDeSuscripcion;
	private ArrayList<Autorizado> autorizados;
	
	public Socio() {
		super();
		autorizados = new ArrayList<Autorizado>();
	}
	
	

	public Socio(int cedula, String nombre, double fondos, String tipoDeSuscripcion) {
		super(cedula, nombre);
		this.fondos = fondos;
		this.tipoDeSuscripcion = tipoDeSuscripcion;
		autorizados = new ArrayList<Autorizado>();
	}



	public double getFondos() {
		return fondos;
	}

	public void setFondos(double fondos) {
		this.fondos = fondos;
	}

	public String getTipoDeSuscripcion() {
		return tipoDeSuscripcion;
	}

	public void setTipoDeSuscripcion(String tipoDeSuscripcion) {
		this.tipoDeSuscripcion = tipoDeSuscripcion;
	}
	
	public Autorizado getAutorizado(int posicion) {
		return this.autorizados.get(posicion);
	}
	
	public void setAutorizado(Autorizado autorizado) {
		this.autorizados.add(autorizado);
	}

	public ArrayList<Autorizado> getAutorizados() {
		return autorizados;
	}

	public void setAutorizados(ArrayList<Autorizado> autorizados) {
		this.autorizados = autorizados;
	}
	
	public String mostrarDatos() {
		return "\nNombre: " 	+ this.getNombre()
			  +"\nCedula: " + this.getCedula()
			  +"\nFondos: " 	+ this.getFondos()
			  +"\nTipo de suscripcion: " 	+ this.getTipoDeSuscripcion();
	}

	public String mostrarautorizados() {
		String autorizadosAlmacenados = "";
		for(int i = 0; i < this.autorizados.size(); i++) {
			autorizadosAlmacenados += "\n-----------------";
			autorizadosAlmacenados += "\nAutorizado #" + (i+1);
			autorizadosAlmacenados += "\n_________________";
			autorizadosAlmacenados += this.autorizados.get(i).mostrarDatos();
		}
		return autorizadosAlmacenados;
	}
	
	public String mostrarautorizadosConFacturas() {
		String autorizadosAlmacenados = "";
		for(int i = 0; i < this.autorizados.size(); i++) {
			autorizadosAlmacenados += "\n-----------------";
			autorizadosAlmacenados += "\nAutorizado #" + (i+1);
			autorizadosAlmacenados += "\n_________________";
			autorizadosAlmacenados += this.autorizados.get(i).mostrarDatos();
			autorizadosAlmacenados += this.autorizados.get(i).mostrarFacturas();
		}
		return autorizadosAlmacenados;
	}
}
