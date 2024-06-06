package sem.sem;

public class PuntoDeVenta {
    private ZonaDeEstacionamiento zona;
    private SEM sem;

    public void registrarEstacionamiento(String patente, int horas) {
        sem.registrarEstacionamiento(patente, horas);
    }

    public void cargarCredito(String numeroTel, float credito) throws Exception {
        Cliente cliente = sem.obtenerClienteSegunNumeroTel(numeroTel);
        cliente.cargarCredito(credito);
    }

}