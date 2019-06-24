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

import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="equipo")
public class EquipoModel {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_equipo")
	private Integer idEquipo;
	
	@NotNull
	@Column(name = "nombre_equipo")
	private String nombreEquipo;
	
	@NotNull
	@Column(name = "nombre_entrenador")
	private String nombreEntrenador;
	
	@NotNull
	@Column(name = "nombre_encargado")
	private String nombreEncargado;
	
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private CategoriaModel categoria;


	public Integer getIdEquipo() {
		return idEquipo;
	}


	public void setIdEquipo(Integer idEquipo) {
		this.idEquipo = idEquipo;
	}


	public String getNombreEquipo() {
		return nombreEquipo;
	}


	public void setNombreEquipo(String nombreEquipo) {
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


	public CategoriaModel getCategoria() {
		return categoria;
	}


	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}
	
	/*
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name= "categoria", 
	joinColumns = {@JoinColumn(name="id_categoria")},
	inverseJoinColumns = {@JoinColumn(name="id_socio")}	)
	private List<SocioModel> socioCategoria;

	
	@OneToMany(cascade= CascadeType.MERGE, mappedBy = "sociocategoria", fetch = FetchType.EAGER)
	@JoinColumn(name="id_sociocategoria")
	private List<SocioCategoriaModel> socioCategoria;
	 */
	
	
	
}

