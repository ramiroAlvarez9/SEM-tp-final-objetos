package notificaciones;

public class NotificacionCargaCredito implements INotificacion {
    private final Double credito;

    public NotificacionCargaCredito(Double credito) {
        this.credito = credito;
    }

    public void informar() {
        System.out.printf("Tu crédito es %s %n", credito);
    }

    public Double getCredito() {
        return credito;
    }

}
