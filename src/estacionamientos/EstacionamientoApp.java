package estacionamientos;

import aplicaciones.Aplicacion;
import notificaciones.Notificador;
import sistema.SEM;

import java.time.LocalTime;

public class EstacionamientoApp extends Estacionamiento {
    private final String numeroTel;

    public EstacionamientoApp(Notificador notificador, Aplicacion app) {
        super(notificador, app.getPatente());
        this.fin = app.getHoraMaximaDeEstacionamiento();
        this.numeroTel = app.getNumeroTel();
    }

    public String getNumeroTel() {
        return numeroTel;
    }
    
    @Override
    public void finalizar(SEM sem, Notificador notificador){
        setFin(LocalTime.now());
        sem.restarCredito(numeroTel, costo());

        this.esVigente = false;
        notificador.notificarFinEstacionamiento(patente, fin, costo());
    }

}
