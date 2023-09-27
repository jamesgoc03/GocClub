package Controladores;

import java.util.ArrayList;
import ModeloImp.Socio;

public interface ControladorSocioBussiness {
	public void validarCupoParaSocio(String tipoDeSuscripcion, ArrayList<Socio> socio) throws Exception;
	public void eliminarSocio(ArrayList<Socio> socios, int cedula) throws Exception;
}
