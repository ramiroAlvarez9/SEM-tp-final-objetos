package sem.usuarios;

import sem.dispositivos.Celular;

public class Cliente extends Usuario {
    final String numeroTel;
    final String patente;
    private float credito;
    private Celular celular;

    public Cliente(String numeroTel, String patente) {
        this.numeroTel = numeroTel;
        this.patente = patente;
        this.credito = 0;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public String getPatente() {
        return patente;
    }

    public float getCredito() {
        return credito;
    }

    public void cargarCredito(float credito) {
        this.credito = credito;
    }
}