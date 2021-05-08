package dominio;

import java.time.LocalDate;

public class Oferta {
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private int descuento;

	public Oferta(LocalDate fechaInicio, LocalDate fechaFin, int descuento) {
		if (fechaInicio.isAfter(fechaFin)) {
			throw new RuntimeException("La fecha de inicio debe ser anterior a la fecha de fin");
		}
		if (fechaFin.isBefore(LocalDate.now())) {
			throw new RuntimeException("La fecha de fin debe ser posterior a la fecha actual");
		}
		if (descuento < 0) {
			throw new RuntimeException("El descuento debe ser mayor a 0");
		}
	}

	public int descuento() {
		return this.descuento;
	}
}
