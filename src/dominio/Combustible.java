package dominio;

import java.time.LocalDate;

public abstract class Combustible {
	private float precioLitro;

	public Combustible(float precioLitro) throws RuntimeException {
		if (precioLitro <= 0)
			throw new RuntimeException("El precio debe ser mayor a 0");
		this.precioLitro = precioLitro;
	}

	public abstract float calcularMonto(float litros, LocalDate fecha);

}
