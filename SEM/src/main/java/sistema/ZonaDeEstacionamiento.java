package sistema;

import estacionamientos.Estacionamiento;
import estacionamientos.EstacionamientoApp;
import estacionamientos.EstacionamientoPuntual;
import notificaciones.Notificador;
import usuarios.Inspector;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Stream;

public class ZonaDeEstacionamiento {
    private HashSet<Estacionamiento> estacionamientos;
    private HashSet<Inspector> inspectores;
    private final Notificador notificador;

    public ZonaDeEstacionamiento(HashSet<Inspector> inspectores) {
        this.estacionamientos = new HashSet<>();
        this.notificador = new Notificador();
        this.inspectores = inspectores;
    }

    public Stream<EstacionamientoApp> obtenerEstacionamientosApp() {
        return estacionamientos
                .stream()
                .filter(EstacionamientoApp.class::isInstance)
                .map(e -> (EstacionamientoApp) e);
    }

    public void registrarEstacionamiento(String patente, int horas) {
        Estacionamiento e = new EstacionamientoPuntual(notificador, patente, horas);
        estacionamientos.add(e);
    }

    public void registrarEstacionamiento(String patente, String numeroTel) {
        Estacionamiento e = new EstacionamientoApp(notificador, patente, numeroTel);
        estacionamientos.add(e);
    }

    public void finalizarEstacionamiento(String numeroTel) {
        EstacionamientoApp e = obtenerEstacionamientosApp()
                .filter(es -> Objects.equals(es.getNumeroTel(), numeroTel))
                .findAny()
                .orElseThrow();

        e.finalizar(notificador);
        estacionamientos.remove(e);
    }

    public void finalizarTodosLosEstacionamientos() {
        for(Estacionamiento e : estacionamientos) {
            e.finalizar(notificador);
        }
        this.estacionamientos = new HashSet<>();
    }

    public Notificador getNotificador() {
        return notificador;
    }

}
