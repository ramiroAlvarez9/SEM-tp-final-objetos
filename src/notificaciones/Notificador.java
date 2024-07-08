package notificaciones;

import java.time.LocalTime;
import java.util.HashSet;

public class Notificador {
    private final HashSet<Entidad> entidades;

    public Notificador() {
        this.entidades = new HashSet<>();
    }

    public HashSet<Entidad> getEntidades(){
    	return entidades;
    }
    
	public void suscribir(Entidad notificado) {
        entidades.add(notificado);
    }

    public void desuscribir(Entidad notificado) {
        entidades.remove(notificado);
    }

    public void notificarCredito(double creditoNuevo) {
        for(Entidad entidad : entidades) {
            entidad.cargaCredito(creditoNuevo);
        }
    }

    public void notificarInicioEstacionamiento(String patente, LocalTime horaInicio) {
        for(Entidad entidad : entidades) {
            entidad.inicioEstacionamiento(patente, horaInicio);
        }
    }

    public void notificarFinEstacionamiento(String patente, LocalTime horaFin, double costo) {
        for(Entidad entidad : entidades) {
            entidad.finEstacionamiento(patente, horaFin, costo);
        }
    }
}
