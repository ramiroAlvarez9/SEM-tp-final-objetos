package compras;

import java.time.LocalDate;
import java.time.LocalTime;

public class CompraCelular extends Compra {
	private String numeroTel;
	private double monto;

	public CompraCelular(LocalDate fecha, LocalTime hora, String numeroTel, double monto) {
		super(fecha, hora);
		this.numeroTel = numeroTel;
		this.monto = monto;
	}

	public String getNumeroTel() {
		return this.numeroTel;
	}

	public double getMonto() {
		return this.monto;
	}
}
