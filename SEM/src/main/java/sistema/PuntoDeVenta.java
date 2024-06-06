package sistema;

import notificaciones.CargaCredito;

public class PuntoDeVenta {
    private final ZonaDeEstacionamiento zona;

    public PuntoDeVenta(ZonaDeEstacionamiento zona) {
        this.zona = zona;
    }

    public void cargarCredito(String numeroTel, Double credito) {
        zona.getNotificador().notificar(numeroTel, new CargaCredito(credito));
    }
}