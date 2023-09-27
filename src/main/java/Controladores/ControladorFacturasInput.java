package Controladores;

public interface ControladorFacturasInput {
	public String validarConceptoConsumo (String nombre) throws Exception;
	public double validarValor (String fondos) throws Exception;	
}
