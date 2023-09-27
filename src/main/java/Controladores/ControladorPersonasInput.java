package Controladores;

public interface ControladorPersonasInput {
	
	public String validarNombre (String nombre) throws Exception;
	public int validarCedula (String cedula) throws Exception;
	public double validarFondos (String fondos) throws Exception;
	public String validarTipoDeSuscripcion (String numeroDeSuscripcion) throws Exception;
	
}
