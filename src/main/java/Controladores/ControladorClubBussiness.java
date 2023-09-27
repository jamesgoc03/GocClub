package Controladores;

public interface ControladorClubBussiness {
	public void validarTope(double valorMinimo, double valorMaximo, double valor) throws Exception;
	public void validarTopeMinimo(String tipoDeSuscripcion, double fondos) throws Exception;
	public void validarTopeMaximo(String tipoDeSuscripcion, double fondos) throws Exception;
	public void validarFondosSuficientes (double valorASuperar, double fondos) throws Exception;
}
