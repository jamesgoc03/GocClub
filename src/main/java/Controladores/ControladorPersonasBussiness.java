package Controladores;

import java.util.ArrayList;
import ModeloImp.Socio;
import ModeloImp.Autorizado;

public interface ControladorPersonasBussiness {
	public Socio buscarSocio(ArrayList<Socio> socios, int cedula) throws Exception;
	public Autorizado buscarAutorizado(ArrayList<Socio> socios, int cedula) throws Exception;
	public void descartarCedulaEnSocios(ArrayList<Socio> socios, int cedula) throws Exception;
	public void descartarCedulaEnAutorizados(ArrayList<Socio> socios, int cedula) throws Exception;
}
