package compras;

import java.time.LocalDate;
import java.time.LocalTime;

public class CompraHora extends Compra {

	private int cantHoras;

	public CompraHora(int numControl, LocalDate fecha, LocalTime hora, int cantHoras) {
		super(numControl, fecha, hora);

		this.numControl = numControl;
		this.fecha = fecha;
		this.hora = hora;
		this.cantHoras = cantHoras;
	}

	public int getCantHoras() {
		return this.cantHoras;
	}

}
