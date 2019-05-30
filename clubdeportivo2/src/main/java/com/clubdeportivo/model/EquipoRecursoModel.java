package com.clubdeportivo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="equipo_recurso")
public class EquipoRecursoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEquipoRecurso;
	

	@OneToMany(cascade= CascadeType.MERGE, mappedBy = "equipo", fetch = FetchType.EAGER)
	@JoinColumn(name="id_equipo")
	private List<EquipoModel> equipo;

	@OneToMany(cascade= CascadeType.MERGE, mappedBy = "recursos", fetch = FetchType.EAGER)
	@JoinColumn(name="id_recursos")
	private List<RecursosModel> recursos;

	public int getIdEquipoRecurso() {
		return idEquipoRecurso;
	}

	public void setIdEquipoRecurso(int idEquipoRecurso) {
		this.idEquipoRecurso = idEquipoRecurso;
	}

	public List<EquipoModel> getEquipo() {
		return equipo;
	}

	public void setEquipo(List<EquipoModel> equipo) {
		this.equipo = equipo;
	}

	public List<RecursosModel> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<RecursosModel> recursos) {
		this.recursos = recursos;
	}

	@Override
	public String toString() {
		return "EquipoRecursoModel [idEquipoRecurso=" + idEquipoRecurso + ", equipo=" + equipo + ", recursos="
				+ recursos + "]";
	}
	
	
	
}
