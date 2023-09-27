package Controladores;

import java.util.ArrayList;
import ModeloImp.Factura;
import ModeloImp.Socio;
import ModeloImp.Autorizado;

public interface ControladorFacturasBussiness {

	public void validarNumeroDeFacturas(ArrayList<Factura> facturas) throws Exception;
	public void pagarFacturaSocio(Socio socio, int numeroDeFactura) throws Exception;
	public void pagarFacturaAutorizado(Socio socio, Autorizado autorizado, int cedula, int numeroDeFactura) throws Exception;
	public void validarFacturasPendientes(ArrayList<Factura> facturas) throws Exception;
	
}
