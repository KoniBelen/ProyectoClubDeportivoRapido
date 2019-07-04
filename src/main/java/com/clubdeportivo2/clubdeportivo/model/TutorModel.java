package com.clubdeportivo2.clubdeportivo.model;


import java.util.Date;
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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import com.clubdeportivo2.clubdeportivo.Validator.ValidaEdadSocio;
import com.clubdeportivo2.clubdeportivo.Validator.ValidaMayorEdad;
import com.clubdeportivo2.clubdeportivo.Validator.ValidaRut;

@Entity
@Table(name="tutor")
public class TutorModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tutor")
	private Integer idTutor;
	
	@NotEmpty(message="Campo obligatorio (*)")
	@ValidaRut(message="Ingrese un Rut válido")
	@Column(name="rut_tutor")
	private String rutTutor;
	
	@NotEmpty(message="Campo obligatorio (*)")
	@Size(min=3,max=150, message="Ingrese un nombre de mínimo 3 caracteres")
	@Column(name="nombre_tutor")
	private String nombreTutor;
	
	@NotEmpty(message="Campo obligatorio (*)")
	@Size(min=3,max=150, message="Ingrese un nombre de mínimo 3 caracteres")
	@Column(name="apellido_materno")
	private String apellidoMaternoTutor;
	
	@NotEmpty(message="Campo obligatorio (*)")
	@Size(min=3,max=150, message="Ingrese un nombre de mínimo 3 caracteres")
	@Column(name="apellido_paterno")
	private String apellidoPaternoTutor;
	
	@NotNull(message="Campo obligatorio (*)")
	@Range(min=100000000, max=999999999 , message="Ingrese un número de teléfono de 9 digitos")
	@Column(name="telefono_tutor")
	private Long telefonoTutor;
	
	@NotEmpty(message="Campo obligatorio (*)")
	@Size(min=3,max=150, message="Ingrese una dirección de mínimo 3 caracteres")
	@Column(name="direccion_tutor")
	private String direccionTutor;
	
	@NotNull(message="Campo obligatorio (*)")
	@ValidaMayorEdad(message = "El tutor debe ser mayor de edad")
	@Past(message="La fecha de nacimiento debe ser anterior a la fecha de hoy")
	@Column(name= "f_nacimiento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimientoTutor;
	
	@NotEmpty(message="Campo obligatorio (*)")
	@Email(message="Formato email incorrecto xxxx@xxx.xxx")
	@Column(name="email_tutor")
	private String emailTutor;
	
	@OneToMany(cascade= CascadeType.MERGE, mappedBy = "tutor", fetch = FetchType.EAGER)
	private List<SocioModel> socio;

	public Integer getIdTutor() {
		return idTutor;
	}

	public void setIdTutor(Integer idTutor) {
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

	public Long getTelefonoTutor() {
		return telefonoTutor;
	}

	public void setTelefonoTutor(Long telefonoTutor) {
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
				+ fechaNacimientoTutor + ", emailTutor=" + emailTutor+"]";
	}
	

}
