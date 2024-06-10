package compras;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Compra {
    static int lastID = 0;
    protected int numControl;
    protected LocalDate fecha;
    protected LocalTime hora;

    public Compra(LocalDate fecha, LocalTime hora) {
        this.numControl = lastID++;
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

