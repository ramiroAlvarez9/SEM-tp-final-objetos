package aplicaciones;

import modos.Modo;
import modos.ModoAutomatico;
import modos.ModoManual;
import notificaciones.*;
import sistema.SEM;

public class Aplicacion implements MovementSensor, INotificado {
    private final SEM sem;
    private final String patente;
    private final String numeroTel;
    private Modo modo;

    public Aplicacion(SEM sem, String patente, String numeroTel) {
        this.sem = sem;
        this.patente = patente;
        this.numeroTel = numeroTel;
        this.modo      = new ModoManual();
        sem.registrarApp(this);        
    }

    public void iniciarEstacionamiento() {
        modo.iniciarEstacionamiento(this);
    }

    public void finalizarEstacionamiento() {
        modo.finalizarEstacionamiento(this);
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
    
    public SEM getSem() {
    	return this.sem;
    }
    public void setModoAplicacion(Modo modo) {
    	this.modo = modo; 

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
