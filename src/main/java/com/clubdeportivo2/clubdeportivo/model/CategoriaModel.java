package com.clubdeportivo2.clubdeportivo.model;


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
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="categoria")
public class CategoriaModel {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Integer idCategoria;
	
	@NotEmpty(message= "EL nombre es requerido")
	@Size(min=3, max=150, message="El nombre de la categoria debe tener al menos 3 caracteres")
	@Column(name = "nombre_categoria")
	private String nombreCategoria;
	
	@NotEmpty//(message="La descripción de la categoria es requerida")
	@Column(name = "descripcion_categoria")
	private String descripcionCategoria;
	
	@NotNull//(message = "El valor de la edad máxima es requerido")
	@DecimalMax(value = "150", message = "La edad máxima de la categoria es 150")
	@DecimalMin(value = "4", message = "La edad minima de la categoria es 4")
	@Column(name = "edad_max")
	private int edadMax;
	
	@NotEmpty//(message="El genero de la categoría es requerido")
	@Column(name = "genero_categoria")
	private String generoCategoria;	
	
	@NotNull
	@Column(name = "estado_categoria")
	private boolean estadoCategoria;
	
	@NotNull (message="El deporte es requerido")
	@ManyToOne
	@JoinColumn(name = "id_deporte")
	private DeporteModel deporteCategoria;
	
	
	@ManyToMany(mappedBy = "categorias")
	private List<SocioModel> sociosCategoria;

	
	
	@OneToMany(cascade= CascadeType.MERGE, mappedBy = "idEquipo")
	private List<EquipoModel> equiposCategoria;



	public Integer getIdCategoria() {
		return idCategoria;
	}



	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}



	public String getNombreCategoria() {
		return nombreCategoria;
	}



	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}



	public String getDescripcionCategoria() {
		return descripcionCategoria;
	}



	public void setDescripcionCategoria(String descripcionCategoria) {
		this.descripcionCategoria = descripcionCategoria;
	}



	public int getEdadMax() {
		return edadMax;
	}



	public void setEdadMax(int edadMax) {
		this.edadMax = edadMax;
	}



	public String getGeneroCategoria() {
		return generoCategoria;
	}



	public void setGeneroCategoria(String generoCategoria) {
		this.generoCategoria = generoCategoria;
	}



	public boolean isEstadoCategoria() {
		return estadoCategoria;
	}



	public void setEstadoCategoria(boolean estadoCategoria) {
		this.estadoCategoria = estadoCategoria;
	}



	public DeporteModel getDeporteCategoria() {
		return deporteCategoria;
	}



	public void setDeporteCategoria(DeporteModel deporteCategoria) {
		this.deporteCategoria = deporteCategoria;
	}



	public List<SocioModel> getSociosCategoria() {
		return sociosCategoria;
	}



	public void setSociosCategoria(List<SocioModel> sociosCategoria) {
		this.sociosCategoria = sociosCategoria;
	}



	public List<EquipoModel> getEquiposCategoria() {
		return equiposCategoria;
	}



	public void setEquiposCategoria(List<EquipoModel> equiposCategoria) {
		this.equiposCategoria = equiposCategoria;
	}



	@Override
	public String toString() {
		return "CategoriaModel [idCategoria=" + idCategoria + ", nombreCategoria=" + nombreCategoria
				+ ", descripcionCategoria=" + descripcionCategoria + ", edadMax=" + edadMax + ", generoCategoria="
				+ generoCategoria + ", estadoCategoria=" + estadoCategoria + ", deporteCategoria=" + deporteCategoria
				+ ", equiposCategoria=" + equiposCategoria + "]";
	}

	
}