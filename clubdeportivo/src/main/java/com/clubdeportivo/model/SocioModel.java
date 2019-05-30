<<<<<<< HEAD:clubdeportivo/src/main/java/com/clubdeportivo/model/SocioModel.java
package com.clubdeportivo.model;

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
	private int idSocio;
	
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
	private int telefonoSocio;
	
	@NotNull
	@Column(name="direccion_socio")
	private String direccionSocio;
	
	@NotNull
	@Column(name= "f_nacimiento")
	private Date fechaNacimientoSocio;
	
	@NotNull
	@Column(name="email_socio")
	private String emailSocio;
	

	@NotNull
	@Column(name="genero_socio")
	private String generoSocio;
	
	@NotNull
	@Column(name="estado_socio")
	private boolean estadoSocio;
	

	@OneToMany(cascade= CascadeType.MERGE, mappedBy = "sociocategoria", fetch = FetchType.EAGER)
	@JoinColumn(name="id_sociocategoria")
	private List<SocioCategoriaModel> socioCategoria;
	
<<<<<<< HEAD:clubdeportivo2/src/main/java/com/clubdeportivo/model/SocioModel.java
=======


>>>>>>> parent of cc35126... [Merge]:clubdeportivo/src/main/java/com/clubdeportivo/model/SocioModel.java
	@ManyToOne
	@JoinColumn(name="id_tutor")
	private TutorModel idTutor;
	
<<<<<<< HEAD:clubdeportivo2/src/main/java/com/clubdeportivo/model/SocioModel.java
	@OneToMany(cascade= CascadeType.MERGE, mappedBy = "cuotas", fetch = FetchType.EAGER)
	@JoinColumn(name="id_cuotas")
	private List<CuotasModel> idCuotas;
=======
	@ManyToOne
	@JoinColumn(name="id_cuotas")
	private CuotasModel idCuotas;
>>>>>>> parent of cc35126... [Merge]:clubdeportivo/src/main/java/com/clubdeportivo/model/SocioModel.java

	public int getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(int idSocio) {
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

	public int getTelefonoSocio() {
		return telefonoSocio;
	}

	public void setTelefonoSocio(int telefonoSocio) {
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


	
	
	public List<SocioCategoriaModel> getSocioCategoria() {
		return socioCategoria;
	}

	public void setSocioCategoria(List<SocioCategoriaModel> socioCategoria) {
		this.socioCategoria = socioCategoria;
	}

	public TutorModel getIdTutor() {
		return idTutor;
	}

	public void setIdTutor(TutorModel idTutor) {
		this.idTutor = idTutor;
	}

<<<<<<< HEAD:clubdeportivo2/src/main/java/com/clubdeportivo/model/SocioModel.java
	

	
	public List<CuotasModel> getIdCuotas() {
		return idCuotas;
	}

	public void setIdCuotas(List<CuotasModel> idCuotas) {
		this.idCuotas = idCuotas;
	}

=======
	public CuotasModel getIdCuotas() {
		return idCuotas;
	}

	public void setIdCuotas(CuotasModel idCuotas) {
		this.idCuotas = idCuotas;
	}

	
>>>>>>> parent of cc35126... [Merge]:clubdeportivo/src/main/java/com/clubdeportivo/model/SocioModel.java
	public boolean isEstadoSocio() {
		return estadoSocio;
	}

	public void setEstadoSocio(boolean estadoSocio) {
		this.estadoSocio = estadoSocio;
	}

	@Override
	public String toString() {
		return "SocioModel [idSocio=" + idSocio + ", rutSocio=" + rutSocio + ", nombreSocio=" + nombreSocio
				+ ", apellidoMaterno=" + apellidoMaterno + ", apellidoPaterno=" + apellidoPaterno + ", telefonoSocio="
				+ telefonoSocio + ", direccionSocio=" + direccionSocio + ", fechaNacimientoSocio="
				+ fechaNacimientoSocio + ", emailSocio=" + emailSocio + ", generoSocio=" + generoSocio
				+ ", estadoSocio=" + estadoSocio + ", socioCategoria=" + socioCategoria + ", idTutor=" + idTutor
				+ ", idCuotas=" + idCuotas + "]";
	}

<<<<<<< HEAD:clubdeportivo2/src/main/java/com/clubdeportivo/model/SocioModel.java


=======
>>>>>>> parent of cc35126... [Merge]:clubdeportivo/src/main/java/com/clubdeportivo/model/SocioModel.java
	
	
	
	
	
	
}
=======
package com.clubdeportivo.model;

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
	private int idSocio;
	
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
	private int telefonoSocio;
	
	@NotNull
	@Column(name="direccion_socio")
	private String direccionSocio;
	
	@NotNull
	@Column(name= "f_nacimiento")
	private Date fechaNacimientoSocio;
	
	@NotNull
	@Column(name="email_socio")
	private String emailSocio;
	

	@NotNull
	@Column(name="genero_socio")
	private String generoSocio;
	
	@NotNull
	@Column(name="estado_socio")
	private boolean estadoSocio;
	

	@OneToMany(cascade= CascadeType.MERGE, mappedBy = "sociocategoria", fetch = FetchType.EAGER)
	@JoinColumn(name="id_sociocategoria")
	private List<SocioCategoriaModel> socioCategoria;
	


	@ManyToOne
	@JoinColumn(name="id_tutor")
	private TutorModel idTutor;
	
	@ManyToOne
	@JoinColumn(name="id_cuotas")
	private CuotasModel idCuotas;

	public int getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(int idSocio) {
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

	public int getTelefonoSocio() {
		return telefonoSocio;
	}

	public void setTelefonoSocio(int telefonoSocio) {
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


	
	
	public List<SocioCategoriaModel> getSocioCategoria() {
		return socioCategoria;
	}

	public void setSocioCategoria(List<SocioCategoriaModel> socioCategoria) {
		this.socioCategoria = socioCategoria;
	}

	public TutorModel getIdTutor() {
		return idTutor;
	}

	public void setIdTutor(TutorModel idTutor) {
		this.idTutor = idTutor;
	}

	public CuotasModel getIdCuotas() {
		return idCuotas;
	}

	public void setIdCuotas(CuotasModel idCuotas) {
		this.idCuotas = idCuotas;
	}

	
	public boolean isEstadoSocio() {
		return estadoSocio;
	}

	public void setEstadoSocio(boolean estadoSocio) {
		this.estadoSocio = estadoSocio;
	}

	@Override
	public String toString() {
		return "SocioModel [idSocio=" + idSocio + ", rutSocio=" + rutSocio + ", nombreSocio=" + nombreSocio
				+ ", apellidoMaterno=" + apellidoMaterno + ", apellidoPaterno=" + apellidoPaterno + ", telefonoSocio="
				+ telefonoSocio + ", direccionSocio=" + direccionSocio + ", fechaNacimientoSocio="
				+ fechaNacimientoSocio + ", emailSocio=" + emailSocio + ", generoSocio=" + generoSocio
				+ ", estadoSocio=" + estadoSocio + ", socioCategoria=" + socioCategoria + ", idTutor=" + idTutor
				+ ", idCuotas=" + idCuotas + "]";
	}

	
	
	
	
	
	
}
>>>>>>> parent of cc35126... [Merge]:clubdeportivo/src/main/java/com/clubdeportivo/model/SocioModel.java
