package sem.sem;

import java.time.LocalTime;

public class Estacionamiento {
    final String patente;
    final LocalTime inicio;
    private LocalTime fin;

    public Estacionamiento(String patente, LocalTime inicio, LocalTime fin) {
        this.patente = patente;
        this.inicio = inicio;
        this.fin = fin;
    }
}

