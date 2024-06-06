package sem.estacionamientos;

import java.time.LocalTime;

import static sem.sem.SEM.getFinHorario;


public abstract class Estacionamiento {
    final String patente;
    final LocalTime inicio;
    protected LocalTime fin;

    public LocalTime calcularTiempoDentroDe(int horas) {
        return LocalTime.now().plusHours(horas);
    }

    public LocalTime calcularHorarioFin(LocalTime tiempo) {
        /*
         esto es equivalente a:
         if(tiempo.isAfter(finHorario)) {
             return finHorario;
         } else {
             return tiempo;
         }
        */

        LocalTime finHorarioSEM = getFinHorario();
        return tiempo.isAfter(finHorarioSEM) ? finHorarioSEM : tiempo;
    }

    public Estacionamiento(String patente) {
        this.patente = patente;
        this.inicio = LocalTime.now();
    }

    public LocalTime getInicio() {
        return inicio;
    }

    public LocalTime getFin() {
        return inicio;
    }

}

