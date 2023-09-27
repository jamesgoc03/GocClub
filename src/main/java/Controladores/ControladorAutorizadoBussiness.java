package Controladores;

import java.util.ArrayList;
import ModeloImp.Socio;

public interface ControladorAutorizadoBussiness {
	public void validarCupoParaAutorizado(Socio socio)throws Exception;
	public Socio buscarSocioDeAutorizado(ArrayList<Socio> socios, int cedula);
	public void eliminarAutorizado(ArrayList<Socio> socios, int cedula) throws Exception;
}
