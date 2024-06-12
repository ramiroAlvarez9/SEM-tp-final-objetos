package notificaciones;

import java.time.LocalTime;

public class InicioEstacionamiento implements INotificacion {
    private final String patente;
    private final LocalTime horaInicio;

    public InicioEstacionamiento(String patente, LocalTime horaInicio) {
        this.patente = patente;
        this.horaInicio = horaInicio;
    }

    public void informar() {
        System.out.printf("%s se estacionó a las %s\n", patente, horaInicio);
    }

}
