package com.xforce.bancosangre.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "donante")
public class Donante {

	
	@Id
	@NotNull
	@Column(name = "rut_donante")
	private String rutDonante;
	
	@NotNull
	@Column(name = "nombre_donante")
	private String nombreDonante;
	
	@NotNull
	@Column(name = "apellido_donante")
	private String apellidoDonante;
	
	@NotNull
	@Column(name = "direccion_donante")
	private String direccionDonante;
	
	@NotNull
	@Column(name = "tipo_sangre_donante")
	private String tipoSangreDonante;
	
	 @NotNull
	 @Column(name = "f_nacimiento_donante")
	 private Date fNacimientoDonante;
	 
	/* @OneToOne(cascade=CascadeType.ALL)
	 @PrimaryKeyJoinColumn
	 private BolsaSangre BolsaSangre;*/
	 
	public String getRutDonante() {
		return rutDonante;
	}

	public void setRutDonante(String rutDonante) {
		this.rutDonante = rutDonante;
	}

	public String getNombreDonante() {
		return nombreDonante;
	}

	public void setNombreDonante(String nombreDonante) {
		this.nombreDonante = nombreDonante;
	}

	public String getApellidoDonante() {
		return apellidoDonante;
	}

	public void setApellidoDonante(String apellidoDonante) {
		this.apellidoDonante = apellidoDonante;
	}

	public String getDireccionDonante() {
		return direccionDonante;
	}

	public void setDireccionDonante(String direccionDonante) {
		this.direccionDonante = direccionDonante;
	}

	public String getTipoSangreDonante() {
		return tipoSangreDonante;
	}

	public void setTipoSangreDonante(String tipoSangreDonante) {
		this.tipoSangreDonante = tipoSangreDonante;
	}
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	public Date getfNacimientoDonante() {
		return fNacimientoDonante;
	}

	public void setfNacimientoDonante(Date fNacimientoDonante) {
		this.fNacimientoDonante = fNacimientoDonante;
	}

	@Override
	public String toString() {
		return "Donante [rutDonante=" + rutDonante + ", nombreDonante=" + nombreDonante + ", apellidoDonante="
				+ apellidoDonante + ", direccionDonante=" + direccionDonante + ", tipoSangerDonante="
				+ tipoSangreDonante + ", fNacimientoDonante=" + fNacimientoDonante + "]";
	}
	 
	 
}
