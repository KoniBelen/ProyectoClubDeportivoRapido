package com.clubdeportivo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sociocategoria")
public class SocioCategoriaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_sociocategoria")
	private int socioCategoria;
	
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private int idCategoria;

	@ManyToOne
	@JoinColumn(name="id_socio")
	private int idSocio;


	public int getSocioCategoria() {
		return socioCategoria;
	}

	public void setSocioCategoria(int socioCategoria) {
		this.socioCategoria = socioCategoria;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public int getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}

	@Override
	public String toString() {
		return "SocioCategoriaModel [socioCategoria=" + socioCategoria + ", idCategoria=" + idCategoria + ", idSocio="
				+ idSocio + "]";
	}

	
	
}
