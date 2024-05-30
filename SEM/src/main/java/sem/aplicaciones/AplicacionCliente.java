package sem.aplicaciones;

import sem.sem.SEM;
import sem.usuarios.Cliente;

public class AplicacionCliente extends AplicacionSEM implements MovementSensor {
    final SEM sem;
    final Cliente usuario;

    public AplicacionCliente(SEM sem, Cliente usuario) {
        this.sem = sem;
        this.usuario = usuario;
    }

    public void iniciarEstacionamiento() {
        sem.registrarEstacionamiento(usuario.getPatente());
    }

    public void finalizarEstacionamiento() throws Exception {
        sem.finalizarEstacionamiento(usuario.getNumeroTel());
    }

    @Override
    public void driving() {

    }

    @Override
    public void walking() {

    }
}
