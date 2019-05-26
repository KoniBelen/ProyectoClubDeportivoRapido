package com.xforce.bancosangre.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "bolsa_sangre")
public class BolsaSangre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_sangre;

	@NotNull
	@Column(name = "fecha_ingreso")
	private Date fechaIngreso;

	@Column(name = "fecha_retiro")
	
	private Date fechaSalida;

	@NotNull
	@Column(name = "fecha_expiracion")
	private Date fechaExpiracion;

	@NotNull
	@Column(name = "tipo_sangre")
	private String tipo;

	@ManyToOne
	@JoinColumn(name = "id_seccion")
	private Seccion seccion;

	public int getId_sangre() {
		return id_sangre;
	}

	public void setId_sangre(int id_sangre) {
		this.id_sangre = id_sangre;
	}
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	@Override
	public String toString() {
		return "BolsaSangre [id_sangre=" + id_sangre + ", seccion=" + seccion + ", fechaIngreso=" + fechaIngreso
				+ ", fechaSalida=" + fechaSalida + ", fechaExpiracion=" + fechaExpiracion + ", tipo=" + tipo + "]";
	}

}