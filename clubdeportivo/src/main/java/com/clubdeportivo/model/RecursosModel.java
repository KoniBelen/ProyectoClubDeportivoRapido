package com.clubdeportivo.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
@Table(name= "recursos")
public class RecursosModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_recursos")
	private int idRecursos;
	
	@NotNull
	@Column(name= "nombre_recursos")
	private String nombreRecursos;
	
	@NotNull
	@Column(name="cantidad_recurso")
	private int cantidadRecurso;
	
	@NotNull
	@Column(name="descripcion_recurso")
	private String descripcionRecurso;
	

	@OneToMany(cascade= CascadeType.MERGE, mappedBy = "equipo_recurso", fetch = FetchType.EAGER)
	@JoinColumn(name="idequipo_recurso")
	private List<EquipoRecursoModel> equipoRecurso;
	
	
	

	public int getIdRecursos() {
		return idRecursos;
	}

	public void setIdRecursos(int idRecursos) {
		this.idRecursos = idRecursos;
	}

	public String getNombreRecursos() {
		return nombreRecursos;
	}

	public void setNombreRecursos(String nombreRecursos) {
		this.nombreRecursos = nombreRecursos;
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

	public List<EquipoRecursoModel> getEquipoRecurso() {
		return equipoRecurso;
	}

	public void setEquipoRecurso(List<EquipoRecursoModel> equipoRecurso) {
		this.equipoRecurso = equipoRecurso;
	}

	@Override
	public String toString() {
		return "RecursosModel [idRecursos=" + idRecursos + ", nombreRecursos=" + nombreRecursos + ", cantidadRecurso="
				+ cantidadRecurso + ", descripcionRecurso=" + descripcionRecurso + ", equipoRecurso=" + equipoRecurso
				+ "]";
	}




	
	
	
	
}
