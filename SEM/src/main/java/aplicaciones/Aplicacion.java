package aplicaciones;

import notificaciones.*;
import sistema.SEM;
import sistema.ZonaDeEstacionamiento;

import java.awt.*;

public class Aplicacion implements MovementSensor, INotificado {
    private final SEM sem;
    private final String patente;
    private final String numeroTel;
    private Double credito;

    public Aplicacion(SEM sem, String patente, String numeroTel) {
        this.sem = sem;
        this.patente = patente;
        this.numeroTel = numeroTel;
        this.credito = 0.0;
    }

    public Point obtenerUbicacion() {
        return new Point(1, 1);
    }

    public ZonaDeEstacionamiento miZona() {
        return sem.encontrarZona(this.obtenerUbicacion());
    }

    public void iniciarEstacionamiento() {
        miZona().registrarEstacionamiento(patente, numeroTel);
    }

    public void finalizarEstacionamiento() {
        miZona().finalizarEstacionamiento(numeroTel);
    }

    @Override
    public void driving() {

    }

    @Override
    public void walking() {

    }

    @Override
    public void update(INotificacion notificacion) {
        switch (notificacion) {
            case CargaCredito cargaCredito -> {
                this.credito = cargaCredito.getCredito();
            }

            case InicioEstacionamiento inicioEstacionamiento -> {
                inicioEstacionamiento.informar();
            }

            case FinEstacionamiento finEstacionamiento -> {
                this.credito = this.credito - finEstacionamiento.getCosto();
                finEstacionamiento.informar();
            }

            default -> throw new IllegalStateException("Imposible");
        }

    }
}
