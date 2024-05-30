package sem.sem;

import sem.usuarios.Cliente;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SEM {
    final double precioPorHora = 40;
    final LocalTime inicioHorario;
    final LocalTime finHorario;
    private List<Estacionamiento> estacionamientos;
    private List<Cliente> clientes;
    private List<PuntoDeVenta> puntosDeVentas;

    public SEM() {
        this.inicioHorario = LocalTime.of(7, 0);
        this.finHorario = LocalTime.of(20, 0);
        this.estacionamientos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.puntosDeVentas = new ArrayList<>();
    }

    public Cliente obtenerClienteSegunNumeroTel(String numeroTel) throws Exception {
        return clientes.stream()
                .filter((c) -> Objects.equals(c.getNumeroTel(), numeroTel))
                .findFirst()
                .orElseThrow(() -> new Exception("No existe el cliente solicitado"));
    }

    public Estacionamiento obtenerEstacionamientoSegunPatente(String patente) throws Exception {
        return estacionamientos.stream()
                .filter((e) -> Objects.equals(e.patente, patente))
                .findFirst()
                .orElseThrow(() -> new Exception("No existe un estacionamiento con la patente dada."));
    }

    public LocalTime calcularTiempoDentroDe(int horas) {
        return LocalTime.now().plusHours(horas);
    }

    public LocalTime calcularHorarioFin(LocalTime tiempo) {
        return tiempo.isAfter(finHorario) ? finHorario : tiempo;
    }

    public void registrarEstacionamiento(String patente, int horas) {
        Estacionamiento estacionamiento = new Estacionamiento(
                patente,
                LocalTime.now(),
                calcularHorarioFin(calcularTiempoDentroDe(horas))
        );
        estacionamientos.add(estacionamiento);
    }


    public void registrarEstacionamiento(String patente) {
        Estacionamiento estacionamiento = new Estacionamiento(
                patente,
                LocalTime.now(),
                null
        );
        estacionamientos.add(estacionamiento);
    }

    public void finalizarEstacionamiento(String numeroTel) throws Exception {
        Cliente cliente = obtenerClienteSegunNumeroTel(numeroTel);
        Estacionamiento estacionamiento = obtenerEstacionamientoSegunPatente(cliente.getPatente());
        estacionamientos.remove(estacionamiento);
    }

    public void finalizarTodosLosEstacionamientos() {
        this.estacionamientos = new ArrayList<>();
    }

}