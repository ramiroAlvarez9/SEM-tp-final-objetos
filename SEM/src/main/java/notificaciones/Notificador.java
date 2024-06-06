package sem.notificaciones;

import java.util.HashMap;
import java.util.HashSet;

public class Notificador {
    private HashMap<String, HashSet<INotificado>> notificados;

    public void suscribir(INotificado notificado) {
        notificados.add(notificado);
    }

    public void desuscribir(INotificado notificado) {
        notificados.remove(notificado);
    }

    public void notificar(String filtro, INotificacion INotificacion) {
        HashSet<INotificado> notificadosFiltrados = notificados.get(filtro);
        for(INotificado notificado : notificadosFiltrados) {
            notificado.update(INotificacion);
        }
    }

}
