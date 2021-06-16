package main;

import dominio.EstacionDeServicio;
import persistencia.ArchivoTextoPlanoDeVentas;
import ui.VentanaPrincipal;

public class mainArchivoDeTextoPlano {

	public static void main(String[] args) {
		VentanaPrincipal vp = new VentanaPrincipal(new EstacionDeServicio(
				new ArchivoTextoPlanoDeVentas("C:\\Users\\Denis\\Documents\\ArchivosPrueba\\ventas.txt")));

	}

}
