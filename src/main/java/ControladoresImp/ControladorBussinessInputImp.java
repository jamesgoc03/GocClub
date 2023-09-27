package ControladoresImp;

import Controladores.ControladorPersonasInput;
import Controladores.ControladorFacturasInput;

public class ControladorBussinessInputImp extends ControladorInputImp implements ControladorPersonasInput, ControladorFacturasInput {

	@Override
	public String validarNombre(String nombre) throws Exception {
		super.stringVacio(nombre, "El nombre");
		return nombre;
	}

	@Override
	public int validarCedula(String cedula) throws Exception {
		return super.integerValido(cedula, "La cedula ingresada");
	}

	@Override
	public double validarFondos(String fondos) throws Exception {
		return super.doubleValido(fondos, "Los fondos ingresados");
	}

	@Override
	public String validarTipoDeSuscripcion(String numeroDeSuscripcion) throws Exception {
		int definirSuscripcion = super.integerValido(numeroDeSuscripcion, "El tipo de suscripción ingresado");
		if(definirSuscripcion == 1) {
			return "VIP";
		}
		if(definirSuscripcion == 2) {
			return "Regular";
		}
		throw new Exception("El tipo de suscripcion debe ser VIP o Regular");
	}
	
	
	
	
	
	
	
	
	
	@Override
	public String validarConceptoConsumo (String conceptoConsumo) throws Exception {
		super.stringVacio(conceptoConsumo, "El concepto consumo");
		return conceptoConsumo;
	}
	
	@Override
	public double validarValor (String fondos) throws Exception{
		return super.doubleValido(fondos, "El valor");
	}

}
