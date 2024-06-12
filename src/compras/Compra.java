package compras;

import java.time.LocalDate;
import java.time.LocalTime;

import sistema.PuntoDeVenta;

public abstract class Compra {
	static int lastID = 0;
	protected int numControl;
	protected LocalDate fecha;
	protected LocalTime hora;
	protected PuntoDeVenta puntoDeVenta;

	public Compra(LocalDate fecha, LocalTime hora, PuntoDeVenta puntoDeVenta) {
		this.numControl = lastID++;
		this.fecha = fecha;
		this.hora = hora;
		this.puntoDeVenta = puntoDeVenta;
	}

	public int getNumControl() {
		return numControl;
	}

	public LocalDate getFechaCompra() {
		return fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public PuntoDeVenta getPuntoDeVenta() {
		return puntoDeVenta;
	}

	// Hook method
	public String getNumeroTel() {
		// TODO Auto-generated method stub
		return null;
	};

	// Hook method
	public double getMonto() {
		return 0;
	};
	
	//Hook method
	public int getCantHoras() {
		return 0;
	}

}