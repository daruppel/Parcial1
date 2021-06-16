package main;

import dominio.EstacionDeServicio;
import persistencia.JdbcVentas;
import ui.VentanaPrincipal;

public class main {

	public static void main(String[] args) {

		VentanaPrincipal vp = new VentanaPrincipal(
				new EstacionDeServicio(new JdbcVentas("jdbc:mysql://localhost:3306/estaciondeservicio", "root", "")));

	}

}
