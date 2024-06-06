package estacionamientos;

import notificaciones.FinEstacionamiento;
import notificaciones.INotificacion;
import notificaciones.Notificador;

import java.time.LocalTime;

import static sistema.SEM.getFinHorario;

public class EstacionamientoApp extends Estacionamiento {
    private final String numeroTel;

    public EstacionamientoApp(Notificador notificador, String patente, String numeroTel) {
        super(notificador, patente);
        this.fin = getFinHorario();
        this.numeroTel = numeroTel;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void finalizar(Notificador notificador){
        setFin(LocalTime.now());

        INotificacion INotificacion = new FinEstacionamiento(patente, fin, costo());
        notificador.notificar(numeroTel, INotificacion);
    }
}
