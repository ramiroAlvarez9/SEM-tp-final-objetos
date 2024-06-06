package sem.notificaciones;

import java.time.LocalTime;

public class FinEstacionamiento implements INotificacion {
    final LocalTime horaFin;

    public FinEstacionamiento(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public String informar() {
        return "EWA-312 dejó de estacionar a las 12:43 PM y bla bla";
    }
}
