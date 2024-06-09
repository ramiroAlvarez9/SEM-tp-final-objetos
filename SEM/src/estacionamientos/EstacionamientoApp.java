package estacionamientos;

import notificaciones.FinEstacionamiento;
import notificaciones.INotificacion;
import notificaciones.Notificador;
import sistema.SEM;

import java.time.LocalTime;

import static sistema.SEM.getFinHorario;

public class EstacionamientoApp extends Estacionamiento {
    private final String numeroTel;

    public EstacionamientoApp(Notificador notificador, String patente, String numeroTel) {
        super(notificador, patente);
        this.fin = getFinHorario(); // TODO: usar horario fin dependiendo del credito
        this.numeroTel = numeroTel;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    @Override
    public void finalizar(SEM sem, Notificador notificador){
        setFin(LocalTime.now());
        sem.restarCredito(numeroTel, costo());

        INotificacion INotificacion = new FinEstacionamiento(patente, fin, costo());
        notificador.notificar(numeroTel, INotificacion);
    }

}
