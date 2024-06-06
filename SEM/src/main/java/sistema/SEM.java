package sem.sem;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class SEM {
    static final double precioPorHora = 40;
    static final LocalTime inicioHorario = LocalTime.of(7, 0);
    static final LocalTime finHorario = LocalTime.of(20, 0);

    private HashSet<ZonaDeEstacionamiento> zonas;

    public SEM() {
        this.zonas = new HashSet<>();
    }

    public static LocalTime getInicioHorario() {
        return inicioHorario;
    }

    public static LocalTime getFinHorario() {
        return finHorario;
    }
}