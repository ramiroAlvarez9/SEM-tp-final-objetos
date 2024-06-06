package sem.sem;

import sem.estacionamientos.Estacionamiento;
import sem.estacionamientos.EstacionamientoApp;
import sem.estacionamientos.EstacionamientoPuntual;
import sem.notificaciones.FinEstacionamiento;
import sem.notificaciones.INotificacion;
import sem.notificaciones.InicioEstacionamiento;
import sem.notificaciones.Notificador;
import sem.usuarios.Inspector;
import java.util.HashSet;
import java.util.Objects;

public class ZonaDeEstacionamiento {
    private HashSet<Estacionamiento> estacionamientos;
    private HashSet<Inspector> inspectores;
    private Notificador notificador;

    public void registrarEstacionamiento(String patente, int horas) {
        Estacionamiento estacionamiento = new EstacionamientoPuntual(patente, horas);
        estacionamientos.add(estacionamiento);
    }

    public void registrarEstacionamiento(String patente) {
        Estacionamiento estacionamiento = new EstacionamientoApp(patente);
        estacionamientos.add(estacionamiento);

        INotificacion INotificacion = new InicioEstacionamiento(estacionamiento.getInicio());
        notificador.notificar(patente, INotificacion);
    }

    public void finalizarEstacionamiento(String numeroTel) throws Exception {
        Estacionamiento estacionamiento = estacionamientos.stream().filter(e -> Objects.equals(e.numeroTel, numeroTel)).findFirst();
        estacionamientos.remove(estacionamiento);
        INotificacion INotificacion = new FinEstacionamiento(estacionamiento.getFin());
        notificador.notificar(numeroTel, INotificacion);
    }

    public void finalizarTodosLosEstacionamientos() {
        this.estacionamientos = new HashSet<>();
    }

}
