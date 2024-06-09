package sistema;

import aplicaciones.Aplicacion;
import estacionamientos.Estacionamiento;
import estacionamientos.EstacionamientoApp;
import estacionamientos.EstacionamientoPuntual;
import notificaciones.CargaCredito;
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

    public Double getCredito(String numeroTel) {
        return creditos.get(numeroTel);
    }

    public void cargarCredito(String numeroTel, Double credito) {
        creditos.put(numeroTel, getCredito(numeroTel) + credito);
        notificador.notificar(new CargaCredito(credito));
    }

    public void restarCredito(String numeroTel, Double costo) {
        this.creditos.put(numeroTel, getCredito(numeroTel) - costo);
    }

    public ZonaDeEstacionamiento encontrarZona(Point coord) {
        // filtrar zona por coordenar
        return zonas.stream().findAny().orElseThrow();
    }


    public Stream<EstacionamientoApp> obtenerEstacionamientosApp() {
        return estacionamientos
                .stream()
                .filter(EstacionamientoApp.class::isInstance)
                .map(e -> (EstacionamientoApp) e);
    }

    public void registrarEstacionamiento(String patente, int horas) {
        // esto es para compra fija
        Estacionamiento e = new EstacionamientoPuntual(notificador, patente, horas);
        estacionamientos.add(e);
    }

    public void registrarEstacionamiento(String patente, String numeroTel) {
        // esto es desde la app
        Estacionamiento e = new EstacionamientoApp(notificador, patente, numeroTel);
        estacionamientos.add(e);
    }

    public void finalizarEstacionamiento(String numeroTel) {
        // esto es para la app
        EstacionamientoApp e = obtenerEstacionamientosApp()
                .filter(es -> Objects.equals(es.getNumeroTel(), numeroTel))
                .findAny()
                .orElseThrow();

        e.finalizar(this, notificador);
        estacionamientos.remove(e);
    }

    public void finalizarTodosLosEstacionamientos() {
        for(Estacionamiento e : estacionamientos) {
            e.finalizar(this, notificador);
        }
        this.estacionamientos = new HashSet<>();
    }
    
    public Estacionamiento estacionamientoConPatente(String patente) {
    	
    	Estacionamiento e = this.estacionamientos.stream()
                .filter(es -> Objects.equals(es.getPatente(), patente))
                .findAny()
                .orElseThrow();
    	
    	return e;
    }
    
    
    
    
    
    
}