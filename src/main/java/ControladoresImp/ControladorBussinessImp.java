package ControladoresImp;

import java.util.ArrayList;
import Controladores.ControladorPersonasBussiness;
import Controladores.ControladorSocioBussiness;
import Controladores.ControladorAutorizadoBussiness;
import Controladores.ControladorClubBussiness;
import Controladores.ControladorFacturasBussiness;
import ModeloImp.Socio;
import ModeloImp.Autorizado;
import ModeloImp.Factura;

public class ControladorBussinessImp implements ControladorPersonasBussiness, ControladorSocioBussiness, ControladorAutorizadoBussiness, ControladorClubBussiness, ControladorFacturasBussiness {

	@Override
	public Socio buscarSocio(ArrayList<Socio> socios, int cedula) throws Exception{
		for(int i = 0; i < socios.size(); i++) {
			if (cedula == socios.get(i).getCedula()) {
				return socios.get(i);
			}		
		}
		throw new Exception("La persona con el número de cedula " + cedula + " no se encuentra afiliada como socio.");
	}
	
	@Override
	public Autorizado buscarAutorizado(ArrayList<Socio> socios, int cedula) throws Exception {
		for(int i = 0; i < socios.size(); i++) {
			ArrayList<Autorizado> autorizados = socios.get(i).getAutorizados();
			for (int j = 0; j < autorizados.size(); j++) {
				if (cedula == autorizados.get(j).getCedula()) {
					return autorizados.get(j);
				}	
			}
		}
		throw new Exception("La persona con el número de cedula " + cedula + " no se encuentra registrada como autorizada.");
	}
	
	@Override
	public void descartarCedulaEnSocios(ArrayList<Socio> socios, int cedula) throws Exception {
		for(int i = 0; i < socios.size(); i++) {
			if (cedula == socios.get(i).getCedula())
				throw new Exception("La persona se encuentra en el club como socio");
		}
	}
	
	@Override
	public void descartarCedulaEnAutorizados(ArrayList<Socio> socios, int cedula) throws Exception {
		for(int i = 0; i < socios.size(); i++) {
			ArrayList<Autorizado> autorizados = socios.get(i).getAutorizados();
			for (int j = 0; j < autorizados.size(); j++) {
				if (cedula == autorizados.get(j).getCedula()) {
					throw new Exception("La persona se encuentra en el club como autorizado");
				}	
			}
		}	
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	public void validarCupoParaSocio(String tipoDeSuscripcion, ArrayList<Socio> socios) throws Exception {
		
		int contadorDeTipoDeSuscripcion = 0;
		for (int i = 0; i < socios.size(); i++) {
			if (tipoDeSuscripcion.equals(socios.get(i).getTipoDeSuscripcion())) {
				contadorDeTipoDeSuscripcion++;
			}
		}
		
		switch(tipoDeSuscripcion) {
		case "VIP":								
			if(contadorDeTipoDeSuscripcion >= 3) {
				throw new Exception("El cupo para socios de tipo de VIP ya alcanzo su limite.");
			}
			break;
		case "Regular":
			if(contadorDeTipoDeSuscripcion >= 32) {
				throw new Exception("El cupo para socios de tipo de Regular ya alcanzo su limite.");
			}
			break;
		}
	}
	
	@Override
	public void eliminarSocio(ArrayList<Socio> socios, int cedula) throws Exception {
		
		Socio socio = this.buscarSocio(socios, cedula);
		
		if(socio.getTipoDeSuscripcion().equals("VIP")) {
			throw new Exception("El socio no se puede elminar porque tiene una suscripción VIP");
		}
		
		if(!(socio.getFacturas().isEmpty())) {
			throw new Exception("El socio no se puede eliminar porque tiene " + socio.getFacturas().size() 
							   +" facturas pendientes por pagar." );
		}
		
		if(socio.getAutorizados().size() > 1) {
			throw new Exception("El socio no se puede eliminar porque tiene más de un autorizado.");
		}
		
		if(!(socio.getAutorizados().isEmpty())) {
			if(!(socio.getAutorizado(0).getFacturas().isEmpty())) {
				throw new Exception("El socio no se puede eliminar porque tiene un autorizado con "
						+ socio.getAutorizado(0).getFacturas().size() + " facturas pendientes por pagar.");
			}
		}
		
		for(int i = 0; i < socios.size(); i++) {
			if(socios.get(i).getCedula() == socio.getCedula()) {
				socios.remove(i);
				break;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	public void validarCupoParaAutorizado(Socio socio) throws Exception {
		if (socio.getAutorizados().size() >= 10) {
			throw new Exception("El socio ha alcanzado el limite de autorizados que puede registrar.");
		}
	}
	
	@Override
	public Socio buscarSocioDeAutorizado(ArrayList<Socio> socios, int cedula){
		for(int i = 0; i < socios.size(); i++) {
			ArrayList<Autorizado> autorizados = socios.get(i).getAutorizados();
			for (int j = 0; j < autorizados.size(); j++) {
				if (cedula == autorizados.get(j).getCedula()) {
					return socios.get(i);
				}	
			}
		}
		return null;
	}
	
	@Override
	public void eliminarAutorizado(ArrayList<Socio> socios, int cedula) throws Exception {
		Autorizado autorizado = this.buscarAutorizado(socios, cedula);
		
		if(!(autorizado.getFacturas().isEmpty())) {
			System.out.println("No se puede eliminar el autorizado porque tiene " + autorizado.getFacturas().size() 
							 + " facturas pendientes.");
		}
		
		Socio socio = this.buscarSocioDeAutorizado(socios, cedula);
		
		for(int i = 0; i < socio.getAutorizados().size(); i++) {
			if(socio.getAutorizado(i).getCedula() == cedula) {
				socio.getAutorizados().remove(i);
				break;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	public void validarTope(double valorMinimo, double valorMaximo, double valor) throws Exception {
		if (valorMinimo > valorMaximo) {
			throw new Exception(valor + " no esta dentro del tope permitido");
		}		
	}
	
	@Override
	public void validarTopeMinimo(String tipoDeSuscripcion, double fondos) throws Exception {
		switch(tipoDeSuscripcion) {
			case "VIP":								
				this.validarTope(100000d, fondos, fondos);
				break;
			case "Regular":
				this.validarTope(50000d, fondos, fondos);
				break;
		}
	}
	
	@Override
	public void validarTopeMaximo(String tipoDeSuscripcion, double fondos) throws Exception {
		switch(tipoDeSuscripcion) {
			case "VIP":
				this.validarTope(fondos, 5000000, fondos);
				break;
			case "Regular":
				this.validarTope(fondos, 1000000, fondos);
				break;
		}
	}
	
	@Override
	public void validarFondosSuficientes(double valorASuperar, double fondos) throws Exception {
		if (!(fondos >= valorASuperar)) {
			throw new Exception("No cuenta con fondos suficientes para completar esta operación.");
		}
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	public void validarNumeroDeFacturas(ArrayList<Factura> facturas) throws Exception {
		if(facturas.size() >= 20) {
			throw new Exception("El limite de facturas ya ha sido alcanzado por el usuario.");
		}
	}
	
	@Override
	public void pagarFacturaSocio(Socio socio, int numeroDeFactura) throws Exception {
		if (numeroDeFactura < 0 || numeroDeFactura >= socio.getFacturas().size()) {
			throw new Exception("El número de factura que ingreso no existe.");
		}
		Factura factura = socio.getFactura(numeroDeFactura);
		this.validarFondosSuficientes(factura.getValor(), socio.getFondos());
		socio.setFondos(socio.getFondos() - factura.getValor());
		socio.getFacturas().remove(numeroDeFactura);
	}
	
	@Override
	public void pagarFacturaAutorizado(Socio socio, Autorizado autorizado, int cedula, int numeroDeFactura) throws Exception {
		if (cedula != socio.getCedula()) {
			throw new Exception("No se puede completar la operación porque el número de cedula del socio "
							  + "no es correcto.");
		}
		
		if (numeroDeFactura < 0 || numeroDeFactura >= autorizado.getFacturas().size()) {
			throw new Exception("El número de factura que ingreso no existe.");
		}
		
		Factura factura = autorizado.getFactura(numeroDeFactura);
		this.validarFondosSuficientes(factura.getValor(), socio.getFondos());
		socio.setFondos(socio.getFondos() - factura.getValor());
		autorizado.getFacturas().remove(numeroDeFactura);
	}
	
	@Override
	public void validarFacturasPendientes(ArrayList<Factura> facturas) throws Exception {
		if(facturas.isEmpty()) {
			throw new Exception("El usuario no tiene facturas pendientes por pagar.");
		}
	}
	
}
