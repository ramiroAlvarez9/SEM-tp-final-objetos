package notificaciones;

import java.time.LocalTime;

public interface Entidad {
    void cargaCredito(double creditoNuevo);
    void finEstacionamiento(String patente, LocalTime horaFin, double costo);
    void inicioEstacionamiento(String patente, LocalTime horaInicio);
}
