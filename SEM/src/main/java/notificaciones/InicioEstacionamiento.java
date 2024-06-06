package sem.notificaciones;

import java.time.LocalTime;

public class InicioEstacionamiento implements INotificacion {
    final LocalTime horaInicio;

    public InicioEstacionamiento(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String informar() {
        return "EWA-312 se estacionó a las 12:43 AM y bla bla";
    }

}
