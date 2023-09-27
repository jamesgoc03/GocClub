package ModeloImp;

import java.util.ArrayList;

public class Club {
	
	private ArrayList<Socio> socios;
	
	public Club () {
		socios = new ArrayList<Socio>();
	}

	public ArrayList<Socio> getSocios() {
		return socios;
	}

	public void setSocios(ArrayList<Socio> socios) {
		this.socios = socios;
	}

	public Socio getSocio(int posicion) {
		return socios.get(posicion);
	}
	
	public void setSocio(Socio socio) {
		this.socios.add(socio);
	}
	
	public String mostrarSocios() {
		String sociosAlmacenados = "";
		for(int i = 0; i < this.socios.size(); i++) {
			sociosAlmacenados += "\n-----------------";
			sociosAlmacenados += "\nSocio número" + (i+1);
			sociosAlmacenados += "\n_________________";
			sociosAlmacenados += this.socios.get(i).mostrarDatos();
		}
		return sociosAlmacenados;
	}
	
	public String mostrarSociosConAutorizados() {
		String sociosAlmacenados = "";
		for(int i = 0; i < this.socios.size(); i++) {
			sociosAlmacenados += "\n-----------------";
			sociosAlmacenados += "\nSocio número" + (i+1);
			sociosAlmacenados += "\n_________________";
			sociosAlmacenados += this.socios.get(i).mostrarDatos();
			sociosAlmacenados += this.socios.get(i).mostrarautorizados();
		}
		return sociosAlmacenados;
	}
	
	public String mostrarTodo() {
		String todoLoAlmacenado = "";
		for(int i = 0; i < this.socios.size(); i++) {
			todoLoAlmacenado += "\n-----------------";
			todoLoAlmacenado += "\nSocio número " + (i+1);
			todoLoAlmacenado += "\n_________________";
			todoLoAlmacenado += this.socios.get(i).mostrarDatos();
			todoLoAlmacenado += this.socios.get(i).mostrarFacturas();
			todoLoAlmacenado += this.socios.get(i).mostrarautorizadosConFacturas();

			
		}
		return todoLoAlmacenado;
	}
	
}