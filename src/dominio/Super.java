package dominio;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Super extends Combustible {

	public Super(float precioLitro) {
		super(precioLitro);
	}

	@Override
	public float calcularMonto(float litros, LocalDate fecha) {
		if (LocalDate.now().getDayOfWeek().equals(DayOfWeek.SUNDAY)) {

		}
		return 0;
	}
}
