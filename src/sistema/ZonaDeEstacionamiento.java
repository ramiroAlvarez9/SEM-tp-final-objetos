package sistema;

import usuarios.Inspector;
import java.util.HashSet;

public class ZonaDeEstacionamiento {
    private HashSet<PuntoDeVenta> puntoDeVentas;

    public ZonaDeEstacionamiento(HashSet<Inspector> inspectores) {
        this.puntoDeVentas = new HashSet<>();
    }
}
