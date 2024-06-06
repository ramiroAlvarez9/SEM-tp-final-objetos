package estacionamientos;

import notificaciones.FinEstacionamiento;
import notificaciones.INotificacion;
import notificaciones.InicioEstacionamiento;
import notificaciones.Notificador;
import sistema.SEM;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static sistema.SEM.getFinHorario;
import static sistema.SEM.getPrecioPorHora;


public abstract class Estacionamiento {
    protected final String patente;
    private final LocalTime inicio;
    protected LocalTime fin;

    public Estacionamiento(Notificador notificador, String patente) {
        this.patente = patente;
        this.inicio = LocalTime.now();

        INotificacion INotificacion = new InicioEstacionamiento(patente, inicio);
        notificador.notificar(patente, INotificacion);
    }

    public LocalTime calcularTiempoDentroDe(int horas) {
        return LocalTime.now().plusHours(horas);
    }

    public LocalTime calcularHorarioFin(LocalTime tiempo) {
        /*
         esto es equivalente a:
         if(tiempo.isAfter(finHorario)) {
             return finHorario;
         } else {
             return tiempo;
         }
        */

        LocalTime finHorarioSEM = getFinHorario();
        return tiempo.isAfter(finHorarioSEM) ? finHorarioSEM : tiempo;
    }

    public Double costo() {
        return getPrecioPorHora() * inicio.until(fin, ChronoUnit.HOURS);
    }

    public String getPatente() {
        return patente;
    }

    public LocalTime getInicio() {
        return inicio;
    }

    public void setFin(LocalTime tiempo) {
        this.fin = calcularHorarioFin(tiempo);
    }

    public void finalizar(SEM _sem, Notificador notificador) {
        INotificacion INotificacion = new FinEstacionamiento(patente, fin, costo());
        notificador.notificar(patente, INotificacion);
    }

}

