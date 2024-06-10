package compras;

import java.time.LocalDate;
import java.time.LocalTime;

public class CompraHora extends Compra {
	private int cantHoras;

	public CompraHora(LocalDate fecha, LocalTime hora, int cantHoras) {
		super(fecha, hora);
		this.cantHoras = cantHoras;
	}

	public int getCantHoras() {
		return this.cantHoras;
	}

}
