package notificaciones;

import java.util.HashMap;
import java.util.HashSet;

public class Notificador {
    private HashMap<String, HashSet<INotificado>> notificados;

    public Notificador() {
        this.notificados = new HashMap<>();
    }

    public void suscribir(String patenteONumero, INotificado notificado) {
        // Notificador empieza vacio {}
        // Si es el primer suscriptor de una patente o numero, y no existe una lista
        // asociada, entonces creamos una
        notificados.computeIfAbsent(patenteONumero, k -> new HashSet<>()).add(notificado);
    }

    public void desuscribir(String patenteONumero, INotificado notificado) {
        notificados.getOrDefault(patenteONumero, new HashSet<>()).remove(notificado);
    }

    public void notificar(String patenteONumero, INotificacion notificacion) {
        HashSet<INotificado> notificadosFiltrados = notificados.getOrDefault(patenteONumero, new HashSet<>());
        for(INotificado notificado : notificadosFiltrados) {
            notificado.update(notificacion);
        }
    }

}
