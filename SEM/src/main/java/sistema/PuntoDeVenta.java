package sistema;

public class PuntoDeVenta {
    private final SEM sem;

    public PuntoDeVenta(SEM sem) {
        this.sem = sem;
    }

    public void cargarCredito(String numeroTel, Double credito) {
        sem.cargarCredito(numeroTel, credito);
    }
}