package aplicaciones;

import notificaciones.*;
import sistema.SEM;

public class Aplicacion implements MovementSensor, INotificado {
    private final SEM sem;
    private final String patente;
    private final String numeroTel;

    public Aplicacion(SEM sem, String patente, String numeroTel) {
        this.sem = sem;
        this.patente = patente;
        this.numeroTel = numeroTel;

        sem.registrarApp(this);
    }

    public void iniciarEstacionamiento() {
        sem.registrarEstacionamiento(patente, numeroTel);
    }

    public void finalizarEstacionamiento() {
        sem.finalizarEstacionamiento(numeroTel);
    }

    public Double getCredito() {
        return sem.getCredito(numeroTel);
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public String getPatente() {
        return patente;
    }

    @Override
    public void driving() {

    }

    @Override
    public void walking() {

    }

    @Override
    public void update(INotificacion notificacion) {
        // solo notifica en modo automatico?
        switch (notificacion) {
            case InicioEstacionamiento inicioEstacionamiento -> {
                inicioEstacionamiento.informar();
            }

            case FinEstacionamiento finEstacionamiento -> {
                finEstacionamiento.informar();
            }

            default -> notificacion.informar();
        }

    }
}
