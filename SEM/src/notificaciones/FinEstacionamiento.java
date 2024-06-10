package notificaciones;

import java.time.LocalTime;

public class FinEstacionamiento implements INotificacion {
    private final String patente;
    private final LocalTime horaFin;
    private final Double costo;

    public FinEstacionamiento(String patente, LocalTime horaFin, Double costo) {
        this.patente = patente;
        this.horaFin = horaFin;
        this.costo = costo;
    }

    public Double getCosto() {
        return costo;
    }

    public void informar() {
        System.out.printf("%s terminó su estacionamiento a las %s.\n", patente, horaFin);
    }
}
