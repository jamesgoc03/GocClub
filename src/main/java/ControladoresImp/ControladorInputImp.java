package ControladoresImp;

public class ControladorInputImp {
	
	public void stringVacio(String string, String nombreDelDato) throws Exception {
		if (string == null || string.equals("")){
			throw new Exception(nombreDelDato + " no puede ser vacio");
		}
	}
	
	public int integerValido(String string, String nombreDelDato) throws Exception {
		if (string == null || string.equals("")){
			throw new Exception(nombreDelDato + " no puede ser vacio");
		}
		try {
			return Integer.parseInt(string);
		}catch(Exception e) {
			throw new Exception(nombreDelDato + " no es un número valido");
		}
	}
	
	public double doubleValido(String string, String nombreDelDato) throws Exception {
		if (string == null || string.equals("")){
			throw new Exception(nombreDelDato + " no puede ser vacio");
		}
		try {
			return Double.parseDouble(string);
		}catch(Exception e) {
			throw new Exception(nombreDelDato + " no es un número valido");
		}
	}
	
}
