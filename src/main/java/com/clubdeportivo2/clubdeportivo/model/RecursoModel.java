package com.clubdeportivo2.clubdeportivo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;

@Entity
@Table(name="recurso")
public class RecursoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_recurso")
	private Integer idRecurso;

	@NotNull
	@Column(name="nombre_recurso")
	private String nombreRecurso;
	
	@NotNull
	@Column(name="cantidad_recurso")
	private int cantidadRecurso;
	
	@NotNull
	@Column(name="descripcion_recurso")
	private String descripcionRecurso;
	
	@ManyToMany
	@JoinTable(name= "equipoRecurso", 
	joinColumns = {@JoinColumn(name="idRecurso")},
	inverseJoinColumns = {@JoinColumn(name="idDeporte")}	)
	private List<EquipoModel> equipoRecurso;


	public Integer getIdRecurso() {
		return idRecurso;
	}

	public void setIdRecurso(Integer idRecurso) {
		this.idRecurso = idRecurso;
	}

	public String getNombreRecurso() {
		return nombreRecurso;
	}

	public void setNombreRecurso(String nombreRecurso) {
		this.nombreRecurso = nombreRecurso;
	}

	public int getCantidadRecurso() {
		return cantidadRecurso;
	}

	public void setCantidadRecurso(int cantidadRecurso) {
		this.cantidadRecurso = cantidadRecurso;
	}

	public String getDescripcionRecurso() {
		return descripcionRecurso;
	}

	public void setDescripcionRecurso(String descripcionRecurso) {
		this.descripcionRecurso = descripcionRecurso;
	}

	public List<EquipoModel> getEquipoRecurso() {
		return equipoRecurso;
	}

	public void setEquipoRecurso(List<EquipoModel> equipoRecurso) {
		this.equipoRecurso = equipoRecurso;
	}

	@Override
	public String toString() {
		return "RecursoModel [idRecurso=" + idRecurso + ", nombreRecurso=" + nombreRecurso + ", cantidadRecurso="
				+ cantidadRecurso + ", descripcionRecurso=" + descripcionRecurso + ", equipoRecurso=" + equipoRecurso
				+ "]";
	}


	


	

	
	


	

	
	
	
	
}
