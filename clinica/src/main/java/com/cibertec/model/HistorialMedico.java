package com.cibertec.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="historialMedico")
public class HistorialMedico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHistorial;
	private int idPaciente;
	private String fechaHistorial;
	private String diagnostico;
	private String alergias;
	private String tratamiento;
	private String medicoAtendio;
	
	
	
	public int getIdHistorial() {
		return idHistorial;
	}
	public void setIdHistorial(int idHistorial) {
		this.idHistorial = idHistorial;
	}
	public int getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getFechaHistorial() {
		return fechaHistorial;
	}
	public void setFechaHistorial(String fechaHistorial) {
		this.fechaHistorial = fechaHistorial;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getAlergias() {
		return alergias;
	}
	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}
	public String getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	public String getMedicoAtendio() {
		return medicoAtendio;
	}
	public void setMedicoAtendio(String medicoAtendio) {
		this.medicoAtendio = medicoAtendio;
	}
	
	
}
