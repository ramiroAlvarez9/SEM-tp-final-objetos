package sistema;

import usuarios.Inspector;
import java.util.HashSet;

public class ZonaDeEstacionamiento {
	
	private HashSet<Inspector>    inspectores   = new HashSet<>();
    private HashSet<PuntoDeVenta> puntoDeVentas = new HashSet<>();

    public ZonaDeEstacionamiento(HashSet<PuntoDeVenta> puntosDeVenta,HashSet<Inspector> inspectores) {
        this.puntoDeVentas = puntosDeVenta;
        this.inspectores   = inspectores;
    }

	public HashSet<Inspector> getInspectores() {
		return inspectores;
	}

	public HashSet<PuntoDeVenta> getPuntoDeVentas() {
		return puntoDeVentas;
	}
}
