package notificaciones;

import java.time.LocalTime;

public class NotificacionInicioEstacionamiento implements INotificacion {
    private final String patente;
    private final LocalTime horaInicio;

    public NotificacionInicioEstacionamiento(String patente, LocalTime horaInicio) {
        this.patente = patente;
        this.horaInicio = horaInicio;
    }

    public void informar() {
        System.out.printf("%s se estacionó a las %s\n", patente, horaInicio);
    }

}
