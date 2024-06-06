package sistema;

import java.awt.*;
import java.time.LocalTime;
import java.util.HashSet;

public class SEM {
    private static final double precioPorHora = 40;
    private static final LocalTime inicioHorario = LocalTime.of(7, 0);
    private static final LocalTime finHorario = LocalTime.of(20, 0);

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

    public static double getPrecioPorHora() {
        return precioPorHora;
    }

    public ZonaDeEstacionamiento encontrarZona(Point coord) {
        // filtrar zona por coordenar
        return zonas.stream().findAny().orElseThrow();
    }
}