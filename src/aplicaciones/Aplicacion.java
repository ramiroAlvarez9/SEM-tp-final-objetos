package aplicaciones;

import aplicaciones.modos.Modo;
import aplicaciones.modos.ModoManual;
import estacionamientos.EstadoDeEstacionamiento;
import notificaciones.*;
import sistema.SEM;

import java.time.LocalTime;

public class Aplicacion implements MovementSensor, INotificado {
    private final SEM sem;
    private final String patente;
    private final String numeroTel;
    private EstadoDeEstacionamiento estado;
    private Modo modo;

    public Aplicacion(SEM sem, String patente, String numeroTel) {
        this.sem       = sem;
        this.patente   = patente;
        this.numeroTel = numeroTel;
        this.modo      = new ModoManual();
        this.estado    = EstadoDeEstacionamiento.NoVigente;

        sem.registrarApp(this);
    }

    public void iniciarEstacionamiento() {
        modo.iniciarEstacionamiento(this);
        this.estado = EstadoDeEstacionamiento.Vigente;
    }

    public void finalizarEstacionamiento() {
        modo.finalizarEstacionamiento(this);
        this.estado = EstadoDeEstacionamiento.NoVigente;
    }

    public boolean hayEstacionamientoVigente() {
        return sem.hayEstacionamientoVigente(patente);
    }

    public Double getCredito() {
        return sem.getCredito(numeroTel);
    }

    public LocalTime getHoraMaximaDeEstacionamiento() {
        return sem.calcularTiempoFinDe(patente);
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public String getPatente() {
        return patente;
    }

    public EstadoDeEstacionamiento getEstado() {
        return estado;
    }

    public SEM getSem() {
    	return this.sem;
    }

    public void setModo(Modo modo) {
    	this.modo = modo;
    }
   
    @Override
    public void driving() {
        modo.driving(this);
    }

    @Override
    public void walking() {
        modo.walking(this);
    }

    @Override
    public void update(INotificacion notificacion) {
        // solo notifica en modo automatico?
        switch (notificacion) {
            case NotificacionInicioEstacionamiento inicioEstacionamiento -> {
                inicioEstacionamiento.informar();
            }

            case NotificacionFinEstacionamiento finEstacionamiento -> {
                finEstacionamiento.informar();
            }

            default -> notificacion.informar();
        }

    }
}
