package notificaciones;

public class CargaCredito implements INotificacion {
    private final Double credito;

    public CargaCredito(Double credito) {
        this.credito = credito;
    }

    public void informar() {
        System.out.printf("Tu crédito es %s %n", credito);
    }

    public Double getCredito() {
        return credito;
    }

}
