package com.clubdeportivo2.clubdeportivo.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tutor")
public class TutorModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tutor")
	private Integer idTutor;
	
	@NotNull
	@Column(name="rut_tutor")
	private String rutTutor;
	
	@NotNull
	@Column(name="nombre_tutor")
	private String nombreTutor;
	
	@NotNull
	@Column(name="apellido_materno")
	private String apellidoMaternoTutor;
	
	@NotNull
	@Column(name="apellido_paterno")
	private String apellidoPaternoTutor;
	
	@NotNull
	@Column(name="telefono_tutor")
	private int telefonoTutor;
	
	@NotNull
	@Column(name="direccion_tutor")
	private String direccionTutor;
	
	@NotNull
	@Column(name= "f_nacimiento")
	private Date fechaNacimientoTutor;
	
	@NotNull
	@Column(name="email_tutor")
	private String emailTutor;
	
	@OneToMany(cascade= CascadeType.MERGE, mappedBy = "idTutor", fetch = FetchType.EAGER)
	//@JoinColumn(name="id_socio")
	private List<SocioModel> socio;

	public Integer getIdTutor() {
		return idTutor;
	}

	public void setIdTutor(int idTutor) {
		this.idTutor = idTutor;
	}

	public String getRutTutor() {
		return rutTutor;
	}

	public void setRutTutor(String rutTutor) {
		this.rutTutor = rutTutor;
	}

	public String getNombreTutor() {
		return nombreTutor;
	}

	public void setNombreTutor(String nombreTutor) {
		this.nombreTutor = nombreTutor;
	}

	public String getApellidoMaternoTutor() {
		return apellidoMaternoTutor;
	}

	public void setApellidoMaternoTutor(String apellidoMaternoTutor) {
		this.apellidoMaternoTutor = apellidoMaternoTutor;
	}

	public String getApellidoPaternoTutor() {
		return apellidoPaternoTutor;
	}

	public void setApellidoPaternoTutor(String apellidoPaternoTutor) {
		this.apellidoPaternoTutor = apellidoPaternoTutor;
	}

	public int getTelefonoTutor() {
		return telefonoTutor;
	}

	public void setTelefonoTutor(int telefonoTutor) {
		this.telefonoTutor = telefonoTutor;
	}

	public String getDireccionTutor() {
		return direccionTutor;
	}

	public void setDireccionTutor(String direccionTutor) {
		this.direccionTutor = direccionTutor;
	}

	public Date getFechaNacimientoTutor() {
		return fechaNacimientoTutor;
	}

	public void setFechaNacimientoTutor(Date fechaNacimientoTutor) {
		this.fechaNacimientoTutor = fechaNacimientoTutor;
	}

	public String getEmailTutor() {
		return emailTutor;
	}

	public void setEmailTutor(String emailTutor) {
		this.emailTutor = emailTutor;
	}

	public List<SocioModel> getSocio() {
		return socio;
	}

	public void setSocio(List<SocioModel> socio) {
		this.socio = socio;
	}

	@Override
	public String toString() {
		return "TutorModel [idTutor=" + idTutor + ", rutTutor=" + rutTutor + ", nombreTutor=" + nombreTutor
				+ ", apellidoMaternoTutor=" + apellidoMaternoTutor + ", apellidoPaternoTutor=" + apellidoPaternoTutor
				+ ", telefonoTutor=" + telefonoTutor + ", direccionTutor=" + direccionTutor + ", fechaNacimientoTutor="
				+ fechaNacimientoTutor + ", emailTutor=" + emailTutor + ", socio=" + socio + "]";
	}
	

}
