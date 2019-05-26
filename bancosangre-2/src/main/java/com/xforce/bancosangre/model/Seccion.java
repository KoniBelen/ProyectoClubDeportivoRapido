package com.xforce.bancosangre.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "seccion")
public class Seccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_seccion")
	private int idSeccion;

	@NotNull
	@Column(name = "n_estante")
	private int numeroDeEstante;

	@NotNull
	@Column(name = "cantidad_actual")
	private int cantidadActual;

	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "seccion", fetch = FetchType.EAGER)
	private List<BolsaSangre> bolsasSangre;
	
	public Seccion() {
	}
	public Seccion(int idSeccion, int numeroDeEstante, int cantidadActual) {
		this.idSeccion = idSeccion;
		this.numeroDeEstante = numeroDeEstante;
		this.cantidadActual = cantidadActual;
	}

	public int getId_seccion() {
		return idSeccion;
	}

	public void setId_seccion(int id_seccion) {
		this.idSeccion = id_seccion;
	}

	public int getNumeroDeEstante() {
		return numeroDeEstante;
	}

	public void setNumeroDeEstante(int numeroDeEstante) {
		this.numeroDeEstante = numeroDeEstante;
	}

	public int getCantidadActual() {
		return cantidadActual;
	}

	public void setCantidadActual(int cantidadActual) {
		this.cantidadActual = cantidadActual;
	}

	public int getIdSeccion() {
		return idSeccion;
	}

	public void setIdSeccion(int idSeccion) {
		this.idSeccion = idSeccion;
	}

	@JsonIgnore
	protected List<BolsaSangre> getBolsaSangre() {
		return bolsasSangre;
	}

	protected void setBolsaSangre(List<BolsaSangre> bolsaSangre) {
		this.bolsasSangre = bolsaSangre;
	}

	public void addBolsa(BolsaSangre bolsa) {
		bolsasSangre.add(bolsa);

	}

}