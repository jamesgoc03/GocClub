package ModeloImp;

public class Autorizado extends Persona {
	
	public Autorizado() {
		super();
	}
	
	public Autorizado( int cedula, String nombre) {
		super(cedula, nombre);
	}
		
	public String mostrarDatos() {
		return "\nNombre: " 	+ this.getNombre()
			  +"\nCedula: " + this.getCedula();
	}
}
