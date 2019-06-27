package com.clubdeportivo2.clubdeportivo.model;

import java.util.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "socio")
public class SocioModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_socio")
	private Integer idSocio; 	
	
	@NotEmpty(message="Campo obligatorio")
	@Size(min=9, max=13, message="Ingrese un rut valido")
	@Column(name="rut_socio")
	private String rutSocio;
	
	@NotEmpty(message="Campo obligatorio")
	@Size(min=3,max=150, message="Ingrese un nombre entre 3 y 150 caracteres")
	@Column(name="nombre_socio")
	private String nombreSocio;
	
	@NotEmpty(message="Campo obligatorio")
	@Size(min=3,max=150, message="Ingrese un apellido entre 3 y 150 caracteres")
	@Column(name="apellido_paterno")
	private String apellidoPaterno;
	
	@NotEmpty(message="Campo obligatorio")
	@Size(min=3,max=150, message="Ingrese un apellido entre 3 y 150 caracteres")
	@Column(name="apellido_materno")
	private String apellidoMaterno;
	
	@NotNull(message="Campo obligatorio")
	@Range(min=100000000, max=999999999 , message="Ingrese un número de teléfono de 9 digitos")
	@Column(name="telefono_socio")
	private long telefonoSocio;
	
	@NotEmpty(message="Campo obligatorio")
	@Size(min=3,max=150, message="Ingrese una dirección entre 3 y 150 caracteres")
	@Column(name="direccion_socio")
	private String direccionSocio;
	
	@NotNull(message="Campo obligatorio")
	@Past(message="La fecha de nacimiento debe ser anterior a la fecha de hoy")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name= "f_nacimiento")
	private Date fechaNacimientoSocio;
	
	@NotEmpty(message="Campo obligatorio")
	@Email(message="Formato email incorrecto xxxx@xxx.xxx")
	//@Pattern(regexp="^([a-zA-Z0-9\\-\\.\\_]+)'+'(\\@)([a-zA-Z0-9\\-\\.]+)'+'(\\.)([a-zA-Z]{2,4})$", message="Formato email xxxx@xxx.xxx")
	@Column(name="email_socio")
	private String emailSocio;
	
	//@NotNull
	@Column(name="genero_socio")
	private String generoSocio;
	
	//@NotNull
	@Column(name="estado_socio")
	private boolean estadoSocio;
	
	
	
	@ManyToMany
	@JoinTable(name= "socioCategoria", 
	joinColumns = {@JoinColumn(name="idSocio")},
	inverseJoinColumns = {@JoinColumn(name="idCategoria")}	)
	private List<CategoriaModel> categorias;

	@ManyToOne
	@JoinColumn(name="id_tutor")
	private TutorModel tutor;
	
	//los *to many no deben ir con fetch Type no se por que 
	
	@OneToMany(cascade= CascadeType.MERGE, mappedBy = "socioCuota")
	//@JoinColumn(name="id_cuotas")
	private List<CuotasModel> cuotas;

	
	

	public Integer getIdSocio() {
		return idSocio;
	}


	public void setIdSocio(Integer idSocio) {
		this.idSocio = idSocio;
	}


	public String getRutSocio() {
		return rutSocio;
	}


	public void setRutSocio(String rutSocio) {
		this.rutSocio = rutSocio;
	}


	public String getNombreSocio() {
		return nombreSocio;
	}


	public void setNombreSocio(String nombreSocio) {
		this.nombreSocio = nombreSocio;
	}


	public String getApellidoMaterno() {
		return apellidoMaterno;
	}


	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}


	public String getApellidoPaterno() {
		return apellidoPaterno;
	}


	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}


	public long getTelefonoSocio() {
		return telefonoSocio;
	}


	public void setTelefonoSocio(long telefonoSocio) {
		this.telefonoSocio = telefonoSocio;
	}


	public String getDireccionSocio() {
		return direccionSocio;
	}


	public void setDireccionSocio(String direccionSocio) {
		this.direccionSocio = direccionSocio;
	}


	public Date getFechaNacimientoSocio() {
		return fechaNacimientoSocio;
	}


	public void setFechaNacimientoSocio(Date fechaNacimientoSocio) {
		this.fechaNacimientoSocio = fechaNacimientoSocio;
	}


	public String getEmailSocio() {
		return emailSocio;
	}


	public void setEmailSocio(String emailSocio) {
		this.emailSocio = emailSocio;
	}


	public String getGeneroSocio() {
		return generoSocio;
	}


	public void setGeneroSocio(String generoSocio) {
		this.generoSocio = generoSocio;
	}


	public boolean isEstadoSocio() {
		return estadoSocio;
	}


	public void setEstadoSocio(boolean estadoSocio) {
		this.estadoSocio = estadoSocio;
	}


	public List<CategoriaModel> getCategorias() {
		return categorias;
	}


	public void setCategorias(List<CategoriaModel> categorias) {
		this.categorias = categorias;
	}


	public TutorModel getTutor() {
		return tutor;
	}


	public void setTutor(TutorModel tutor) {
		this.tutor = tutor;
	}


	public List<CuotasModel> getCuotas() {
		return cuotas;
	}


	public void setCuotas(List<CuotasModel> cuotas) {
		this.cuotas = cuotas;
	}

	//---------------------------toString-----------------------------------



	@Override
	public String toString() {
		return "SocioModel [idSocio=" + idSocio + ", rutSocio=" + rutSocio + ", nombreSocio=" + nombreSocio
				+ ", apellidoMaterno=" + apellidoMaterno + ", apellidoPaterno=" + apellidoPaterno + ", telefonoSocio="
				+ telefonoSocio + ", direccionSocio=" + direccionSocio + ", fechaNacimientoSocio="
				+ fechaNacimientoSocio + ", emailSocio=" + emailSocio + ", generoSocio=" + generoSocio
				+ ", estadoSocio=" + estadoSocio + ", idTutor=" + tutor+ "]";

	}


	

	



	
	
	
	


	
}
