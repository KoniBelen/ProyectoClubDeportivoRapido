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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "socio")
public class SocioModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_socio")
	private Integer idSocio; 	
	
	@NotNull
	@Column(name="rut_socio")
	private String rutSocio;
	
	@NotNull
	@Column(name="nombre_socio")
	private String nombreSocio;
	
	@NotNull
	@Column(name="apellido_materno")
	private String apellidoMaterno;
	
	@NotNull
	@Column(name="apellido_paterno")
	private String apellidoPaterno;
	
	@NotNull
	@Column(name="telefono_socio")
	private long telefonoSocio;
	
	@NotNull
	@Column(name="direccion_socio")
	private String direccionSocio;
	
	@NotNull
	@Column(name= "f_nacimiento")
	private Date fechaNacimientoSocio;
	
	@NotNull
	@Column(name="email_socio")
	private String emailSocio;
	
	//@NotNull
	@Column(name="genero_socio")
	private String generoSocio;
	
	//@NotNull
	@Column(name="estado_socio")
	private boolean estadoSocio;
	
	/*---relaciones---------------------------------------------------------*/
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE,
			mappedBy = "socioCategoria")
	private List<CategoriaModel> categorias;

	@ManyToOne
	//@JoinColumn(name="id_tutor")
	@JoinColumn
	private TutorModel idTutor;
	
	//los *to many no deben ir con fetch Type no se por que 
	
	@OneToMany(cascade= CascadeType.MERGE, mappedBy = "idSocio")
	//@JoinColumn(name="id_cuotas")
	private List<CuotasModel> idCuotas;

	
	//-----------------------getters y setters----------------------------------

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


	public TutorModel getIdTutor() {
		return idTutor;
	}


	public void setIdTutor(TutorModel idTutor) {
		this.idTutor = idTutor;
	}


	public List<CuotasModel> getIdCuotas() {
		return idCuotas;
	}


	public void setIdCuotas(List<CuotasModel> idCuotas) {
		this.idCuotas = idCuotas;
	}

	
	//---------------------------toString-----------------------------------
	

	@Override
	public String toString() {
		return "SocioModel [idSocio=" + idSocio + ", rutSocio=" + rutSocio + ", nombreSocio=" + nombreSocio
				+ ", apellidoMaterno=" + apellidoMaterno + ", apellidoPaterno=" + apellidoPaterno + ", telefonoSocio="
				+ telefonoSocio + ", direccionSocio=" + direccionSocio + ", fechaNacimientoSocio="
				+ fechaNacimientoSocio + ", emailSocio=" + emailSocio + ", generoSocio=" + generoSocio
				+ ", estadoSocio=" + estadoSocio + ", categorias=" + categorias + ", idTutor=" + idTutor + ", idCuotas="
				+ idCuotas + "]";
	}
	
	
	
	
}