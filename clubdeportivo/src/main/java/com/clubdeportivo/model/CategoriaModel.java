package com.clubdeportivo.model;

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
@Table(name="categoria")
public class CategoriaModel {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private int idCategoria;
	
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
	private String estadoCategoria;	
	
	@ManyToOne
	@JoinColumn(name = "id_deporte")
	private DeporteModel idDeporte;
	
	
	

	@OneToMany(cascade= CascadeType.MERGE, mappedBy = "sociocategoria", fetch = FetchType.EAGER)
	@JoinColumn(name="id_categoria")
	private List<SocioCategoriaModel> socioCategoria;
	
	@OneToMany(cascade= CascadeType.MERGE, mappedBy = "equipo", fetch = FetchType.EAGER)
	@JoinColumn(name="id_categoria")
	private List<EquipoModel> equipo;

	public int getIdCategoria() {
		return idCategoria;
	}

	public String getEstadoCategoria() {
		return estadoCategoria;
	}

	public void setEstadoCategoria(String estadoCategoria) {
		this.estadoCategoria = estadoCategoria;
	}

	public List<EquipoModel> getEquipo() {
		return equipo;
	}

	public void setEquipo(List<EquipoModel> equipo) {
		this.equipo = equipo;
	}

	public void setIdCategoria(int idCategoria) {
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



	public DeporteModel getIdDeporte() {
		return idDeporte;
	}

	public void setIdDeporte(DeporteModel idDeporte) {
		this.idDeporte = idDeporte;
	}

	public List<SocioCategoriaModel> getSocioCategoria() {
		return socioCategoria;
	}

	public void setSocioCategoria(List<SocioCategoriaModel> socioCategoria) {
		this.socioCategoria = socioCategoria;
	}

	@Override
	public String toString() {
		return "CategoriaModel [idCategoria=" + idCategoria + ", nombreCategoria=" + nombreCategoria
				+ ", descripcionCategoria=" + descripcionCategoria + ", edadMax=" + edadMax + ", generoCategoria="
				+ generoCategoria + ", estadoCategoria=" + estadoCategoria + ", idDeporte=" + idDeporte
				+ ", socioCategoria=" + socioCategoria + ", equipo=" + equipo + "]";
	}

	


	
	
}
