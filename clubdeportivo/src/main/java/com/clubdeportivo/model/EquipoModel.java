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
@Table(name="equipo")
public class EquipoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_equipo")
	private int idEquipo;
	
	
	@NotNull
	@Column(name = "nombre_equipo")
	private int nombreEquipo;
	
	@NotNull
	@Column(name = "nombre_entrenador")
	private String nombreEntrenador;
	
	@NotNull
	@Column(name = "nombre_encargado")
	private String nombreEncargado;
	

	@ManyToOne
	@JoinColumn(name="id_categoria")
	private CategoriaModel idCategoria;


	@OneToMany(cascade= CascadeType.MERGE, mappedBy = "equipo_recurso", fetch = FetchType.EAGER)
	@JoinColumn(name="idequipo_recurso")
	private List<EquipoRecursoModel> equipoRecurso;

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public int getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(int nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public String getNombreEntrenador() {
		return nombreEntrenador;
	}

	public void setNombreEntrenador(String nombreEntrenador) {
		this.nombreEntrenador = nombreEntrenador;
	}

	public String getNombreEncargado() {
		return nombreEncargado;
	}

	public void setNombreEncargado(String nombreEncargado) {
		this.nombreEncargado = nombreEncargado;
	}

	public CategoriaModel getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(CategoriaModel idCategoria) {
		this.idCategoria = idCategoria;
	}

	public List<EquipoRecursoModel> getEquipoRecurso() {
		return equipoRecurso;
	}

	public void setEquipoRecurso(List<EquipoRecursoModel> equipoRecurso) {
		this.equipoRecurso = equipoRecurso;
	}

	@Override
	public String toString() {
		return "EquipoModel [idEquipo=" + idEquipo + ", nombreEquipo=" + nombreEquipo + ", nombreEntrenador="
				+ nombreEntrenador + ", nombreEncargado=" + nombreEncargado + ", idCategoria=" + idCategoria
				+ ", equipoRecurso=" + equipoRecurso + "]";
	}



	
}
