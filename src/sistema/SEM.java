package sistema;

import aplicaciones.Aplicacion;
import estacionamientos.Estacionamiento;
import estacionamientos.EstacionamientoApp;
import estacionamientos.EstacionamientoPuntual;
import notificaciones.NotificacionCargaCredito;
import notificaciones.Notificador;

import java.awt.*;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Stream;

public class SEM {
    private static final double precioPorHora = 40;
    private static final LocalTime inicioHorario = LocalTime.of(7, 0);
    private static final LocalTime finHorario = LocalTime.of(20, 0);
    private final Notificador notificador;

    private HashSet<Estacionamiento> estacionamientos;
    private HashSet<ZonaDeEstacionamiento> zonas;
    private HashMap<String, Double> creditos;

    public SEM() {
        this.zonas = new HashSet<>();
        this.estacionamientos = new HashSet<>();
        this.creditos = new HashMap<>();
        this.notificador = new Notificador();
    }

    public static LocalTime getInicioHorario() {
        return inicioHorario;
    }

    public static LocalTime getFinHorario() {
        return finHorario;
    }

    public static double getPrecioPorHora() {
        return precioPorHora;
    }

    public void registrarApp(Aplicacion app) {
        creditos.put(app.getNumeroTel(), 0.0);
        notificador.suscribir(app.getNumeroTel(), app);
        notificador.suscribir(app.getPatente(), app);
    }
    public HashMap<String, Double> getApps() {
    	return this.creditos; 
    }
    
    public Double getCredito(String numeroTel) {
        return creditos.get(numeroTel);
    }

    public void cargarCredito(String numeroTel, Double credito) {
        creditos.put(numeroTel, getCredito(numeroTel) + credito);
        notificador.notificar(new NotificacionCargaCredito(credito));
    }

    public void restarCredito(String numeroTel, Double costo) {
        this.creditos.put(numeroTel, getCredito(numeroTel) - costo);
    }

    public LocalTime calcularTiempoFinDe(String numeroTel) {
    	
        Double credito = this.getCredito(numeroTel);
        LocalTime tiempoCalculado = LocalTime.now().plusHours((long) (credito / precioPorHora));
        
        return tiempoCalculado;
    }

    public ZonaDeEstacionamiento encontrarZona(Point coord) {
        // filtrar zona por coordenar
        return zonas.stream().findAny().orElseThrow();
    }

    public void registrarEstacionamientoDesdeCompraPuntual(String patente, int horas) {
        // esto es para compra fija
        Estacionamiento e = new EstacionamientoPuntual(notificador, patente, horas);
        estacionamientos.add(e);
    }

    public void registrarEstacionamiento(Aplicacion app) {
        // esto es desde la app
        if(!(this.hayEstacionamientoVigente( app.getPatente() ) ) ) {
            Estacionamiento e = new EstacionamientoApp(notificador, app);
            estacionamientos.add(e);
        }
    }
    
    
    public HashSet<Estacionamiento> getEstacionamientos(){
    	return this.estacionamientos;
    }

    public void finalizarEstacionamiento(String numeroTel) {
        // esto es para la app
        EstacionamientoApp e = estacionamientosAppVigentes()
                .filter(es -> Objects.equals(es.getNumeroTel(), numeroTel))
                .findAny()
                .orElseThrow();

        e.finalizar(this, notificador);
    }

    public void finalizarTodosLosEstacionamientos() {
        estacionamientosVigentes().forEach(e -> e.finalizar(this, notificador));
    }

    public Stream<Estacionamiento> estacionamientosVigentes() {
        return estacionamientos.stream()
                .filter(Estacionamiento::esVigente);
    }

    public Stream<EstacionamientoApp> estacionamientosAppVigentes() {
        return estacionamientosVigentes()
                .filter(EstacionamientoApp.class::isInstance)
                .map(e -> (EstacionamientoApp) e);
    }

    public boolean hayEstacionamientoVigente(String patente) {
        return estacionamientos.stream()
                .anyMatch(es -> Objects.equals(es.getPatente(), patente));
    }

    public Estacionamiento estacionamientoConPatente(String patente) {
    	return estacionamientosVigentes()
                .filter(es -> Objects.equals(es.getPatente(), patente))
                .findAny()
                .orElseThrow();
    }
    
}