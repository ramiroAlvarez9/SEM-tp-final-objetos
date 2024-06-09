package compras;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Compra {
    protected int numControl;
    protected LocalDate fecha;
    protected LocalTime hora;

    // Constructor
    public Compra(int numControl, LocalDate fecha, LocalTime hora) {
        this.numControl = numControl;
        this.fecha = fecha;
        this.hora = hora;
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
}

