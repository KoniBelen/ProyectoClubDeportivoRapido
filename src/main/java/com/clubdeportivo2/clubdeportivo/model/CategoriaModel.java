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
import javax.validation.constraints.NotNull;

@Entity
@Table(name="categoria")
public class CategoriaModel {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Integer idCategoria;
	
	@NotNull
	@Column(name = "nombre_categoria")
	private String nombreCategoria;
	
	@NotNull
	@Column(name = "descripcion_categoria")
	private String descripcionCategoria;
	
	@NotNull
	@Column(name = "edad_max")
	private int edadMax;
	
	@NotNull
	@Column(name = "genero_categoria")
	private String generoCategoria;	
	
	@NotNull
	@Column(name = "estado_categoria")
	private boolean estadoCategoria;
	
	@ManyToOne
	@JoinColumn(name = "id_deporte")
	private DeporteModel idDeporte;
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name= "categoria", 
	joinColumns = {@JoinColumn(name="id_categoria")},
	inverseJoinColumns = {@JoinColumn(name="id_socio")}	)
	private List<SocioModel> socioCategoria;

	@OneToMany(cascade= CascadeType.MERGE, mappedBy = "idEquipo")
	//@JoinColumn(name="id_equipo")
	private List<EquipoModel> idEquipo;

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

	public DeporteModel getIdDeporte() {
		return idDeporte;
	}

	public void setIdDeporte(DeporteModel idDeporte) {
		this.idDeporte = idDeporte;
	}

	public List<SocioModel> getSocioCategoria() {
		return socioCategoria;
	}

	public void setSocioCategoria(List<SocioModel> socioCategoria) {
		this.socioCategoria = socioCategoria;
	}

	public List<EquipoModel> getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(List<EquipoModel> idEquipo) {
		this.idEquipo = idEquipo;
	}

	@Override
	public String toString() {
		return "CategoriaModel [idCategoria=" + idCategoria + ", nombreCategoria=" + nombreCategoria
				+ ", descripcionCategoria=" + descripcionCategoria + ", edadMax=" + edadMax + ", generoCategoria="
				+ generoCategoria + ", estadoCategoria=" + estadoCategoria + ", idDeporte=" + idDeporte
				+ ", socioCategoria=" + socioCategoria + ", idEquipo=" + idEquipo + "]";
	}
	
	/*
	@OneToMany(cascade= CascadeType.MERGE, mappedBy = "sociocategoria", fetch = FetchType.EAGER)
	@JoinColumn(name="id_sociocategoria")
	private List<SocioCategoriaModel> socioCategoria;
	 */

	
	
}
