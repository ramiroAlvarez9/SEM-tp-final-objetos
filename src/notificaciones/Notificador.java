package notificaciones;

import java.util.HashMap;
import java.util.HashSet;

public class Notificador {
    private HashSet<INotificado> entidades;
    private HashMap<String, HashSet<INotificado>> aplicaciones;

    public Notificador() {
        this.entidades = new HashSet<>();
        this.aplicaciones = new HashMap<>();
    }
   
    public HashSet<INotificado> getEntidades() {
		return entidades;
	}

	public void suscribir(INotificado notificado) {
        entidades.add(notificado);
    }

    public void suscribir(String patenteONumero, INotificado notificado) {
        aplicaciones.computeIfAbsent(patenteONumero, k -> new HashSet<>()).add(notificado);
    }

    public void desuscribir(INotificado notificado) {
        entidades.remove(notificado);
    }

    public void desuscribir(String patenteONumero, INotificado notificado) {
        aplicaciones.getOrDefault(patenteONumero, new HashSet<>()).remove(notificado);
    }

    public void notificar(INotificacion notificacion) {
        for(INotificado entidad : entidades) {
            entidad.update(notificacion);
        }
    }

    public void notificar(String patenteONumero, INotificacion notificacion) {
        HashSet<INotificado> notificadosFiltrados = aplicaciones.getOrDefault(patenteONumero, new HashSet<>());
        for(INotificado notificado : notificadosFiltrados) {
            notificado.update(notificacion);
        }
    }

}
