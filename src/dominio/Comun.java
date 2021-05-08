package dominio;

import java.time.LocalDate;

public class Comun extends Combustible {

	public Comun(float precioLitro) {
		super(precioLitro);
	}

	@Override
	public float calcularMonto(float litros, LocalDate fecha) {
		return 0;
	}
}
