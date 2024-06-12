package compras;

import java.time.LocalDate;
import java.time.LocalTime;

import sistema.PuntoDeVenta;

public class CompraCelular extends Compra {
	
    private String numeroTel;
    private double monto;

    public CompraCelular(LocalDate fecha, LocalTime hora, String numeroTel, double monto, PuntoDeVenta puntoDeVenta) {
        super(fecha, hora, puntoDeVenta);
        this.numeroTel = numeroTel;
        this.monto = monto;
    }
    
    public PuntoDeVenta getPuntoDeVenta() {
    	return this.puntoDeVenta;
    }
    
    @Override
    public String getNumeroTel() {
        return this.numeroTel;
    }
    @Override
    public double getMonto() {
        return this.monto;
    }
}