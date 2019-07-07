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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import java.util.List;

import javax.persistence.Column;

@Entity
@Table(name="recurso")
public class RecursoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_recurso")
	private Integer idRecurso;

	@NotBlank(message="Campo obligatorio (*)")
	@Size(min=4, max=150, message="Ingrese un recurso entre 4 a 150 caracteres")//150 caracteres
	@Column(name="nombre_recurso")
	private String nombreRecurso;
	
	@NotNull(message="Campo obligatorio (*)")
	//@Size(min=0, max=99999, message="La cantidad de los recursos no puede ser inferior a 0")
	@Min(value =0, message="Los recursos deben ser mayor o igual a 0")
	@Max(value =4294967 , message="Numero ingresado no válido")
	@Column(name="cantidad_recurso")
	private int cantidadRecurso;
	

	@Size(max=200, message="Descripcion demasiado larga")
	@Column(name="descripcion_recurso")
	private String descripcionRecurso;
	
	
	@ManyToMany
	@JoinTable(name= "equipoRecurso", 
	joinColumns = {@JoinColumn(name="idRecurso")},
	inverseJoinColumns = {@JoinColumn(name="idEquipo")}	)
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
				+ cantidadRecurso + ", descripcionRecurso=" + descripcionRecurso + "]";
	}
	
	
}
