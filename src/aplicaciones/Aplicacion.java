package aplicaciones;

import aplicaciones.estados.EstadoDeEstacionamiento;
import aplicaciones.estados.EstadoNoVigente;
import aplicaciones.estados.EstadoVigente;
import aplicaciones.modos.Modo;
import aplicaciones.modos.ModoManual;
import sistema.SEM;

import java.time.LocalTime;

public class Aplicacion implements MovementSensor {
	private final SEM sem;
	private final String patente;
	private final String numeroTel;
	private EstadoDeEstacionamiento estado;
	private Modo modo;
	private final GPS gps;

	public Aplicacion(SEM sem, String patente, String numeroTel) {
		this.sem = sem;
		this.patente = patente;
		this.numeroTel = numeroTel;
		this.modo = new ModoManual();
		this.estado = new EstadoNoVigente();
		this.gps = new GPS();

		sem.registrarApp(this);
	}

	public void iniciarEstacionamiento() {
		this.estado.iniciarEstacionamiento(this);
	}

	public void finalizarEstacionamiento() {
		this.estado.finalizarEstacionamiento(this);
	}

	public boolean hayEstacionamientoVigente() {
		return sem.hayEstacionamientoVigente(patente);
	}

	public Double getCredito() {
		return sem.getCredito(numeroTel);
	}

	public LocalTime getHoraMaximaDeEstacionamiento() {
		return sem.calcularTiempoFinDe(patente);
	}

	public String getNumeroTel() {
		return numeroTel;
	}

	public String getPatente() {
		return patente;
	}

	public EstadoDeEstacionamiento getEstado() {
		return estado;
	}
	
	public void setEstado(EstadoDeEstacionamiento estado) {
		this.estado = estado;
	}

	public SEM getSem() {
		return this.sem;
	}

	public void setModo(Modo modo) {
		this.modo = modo;
	}

	@Override
	public void driving() {
		modo.driving(this);
		
		if (gps.estaEnZonaDeEstacionamiento()) {
			this.recibirAlertaDeFinEstacionamiento();
		}
	}

	@Override
	public void walking() {
		modo.walking(this);
		
		if (gps.estaEnZonaDeEstacionamiento()) {
			this.recibirAlertaDeInicioEstacionamiento();
		} 
	}
	
	public Alerta recibirAlertaDeInicioEstacionamiento() {
		return Alerta.INICIO_ESTACIONAMIENTO;
	}

	public Alerta recibirAlertaDeFinEstacionamiento() {
		return Alerta.FIN_ESTACIONAMIENTO;
	}
}
