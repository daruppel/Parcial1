package dominio;

import java.time.LocalDate;

public class Venta {
	private LocalDate fecha;
	private float litros;
	private Combustible combustible;

	public Venta(LocalDate fecha, float litros, Combustible combustible) {
		if (fecha.isAfter(LocalDate.now())) { // Se permiten crear ventas anterior a la fecha de carga
			throw new RuntimeException("La fecha de la venta no puede ser mayor al día actual");
		}
		if (litros < 0) {
			throw new RuntimeException("Los litros vendidos deben ser mayor a 0");
		}
		this.combustible = combustible;
		this.fecha = fecha;
		this.litros = litros;
	}

	public float monto() {
		return this.combustible.calcularMonto(this.litros, this.fecha);
	}

	public LocalDate fecha() {
		return this.fecha;
	}
}
