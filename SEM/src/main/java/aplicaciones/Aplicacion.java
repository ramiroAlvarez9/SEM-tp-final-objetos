package aplicaciones;

import sistema.SEM;

public class AplicacionCliente extends AplicacionSEM implements MovementSensor {
    final SEM sem;
    final String patente;
    final String numeroTel;
    private Double credito;

    public AplicacionCliente(SEM sem, String patente, String numeroTel) {
        this.sem = sem;
        this.patente = patente;
        this.numeroTel = numeroTel;
        this.credito = 0.0;
    }

    public void iniciarEstacionamiento() {
        sem.registrarEstacionamiento(patente);
    }

    public void finalizarEstacionamiento() throws Exception {
        sem.finalizarEstacionamiento(numeroTel);
    }

    @Override
    public void driving() {

    }

    @Override
    public void walking() {

    }
}
