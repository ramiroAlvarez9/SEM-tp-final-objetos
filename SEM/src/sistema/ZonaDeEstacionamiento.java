package sistema;

import usuarios.Inspector;
import java.util.HashSet;

public class ZonaDeEstacionamiento {
    private HashSet<Inspector> inspectores;
    private HashSet<PuntoDeVenta> puntoDeVentas;

    public ZonaDeEstacionamiento(HashSet<Inspector> inspectores) {
        this.inspectores = inspectores;
        this.puntoDeVentas = new HashSet<>();
    }
}
