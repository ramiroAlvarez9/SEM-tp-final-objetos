package sem.estacionamientos;

import java.time.LocalTime;

public class EstacionamientoApp extends Estacionamiento {

    public EstacionamientoApp(String patente, LocalTime fin) {
        super(patente);
        this.fin = fin;
    }
}
