package com.clubdeportivo2.clubdeportivo.model;


import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name= "deporte")
public class DeporteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_deporte")
	private Integer idDeporte;
	
	@NotNull
	@Column(name= "nombre_deporte")
	private String nombreDeporte;
	
	@NotNull
	@Column(name="estado")
	private boolean estadoDeporte;
	


	@OneToMany(mappedBy = "deporteCategoria")
	private List<CategoriaModel> categorias;
	
	public DeporteModel() {
		
	}

	public DeporteModel(int idDeporte, String nombreDeporte, boolean estadoDeporte) {
		super();
		this.idDeporte = idDeporte;
		this.nombreDeporte = nombreDeporte;
		this.estadoDeporte=estadoDeporte;
	}

	public Integer getIdDeporte() {
		return idDeporte;
	}

	public void setIdDeporte(Integer idDeporte) {
		this.idDeporte = idDeporte;
	}

	public String getNombreDeporte() {
		return nombreDeporte;
	}

	public void setNombreDeporte(String nombreDeporte) {
		this.nombreDeporte = nombreDeporte;
	}

	public boolean isEstadoDeporte() {
		return estadoDeporte;
	}

	public void setEstadoDeporte(boolean estadoDeporte) {
		this.estadoDeporte = estadoDeporte;
	}

	public List<CategoriaModel> getCategoria() {
		return categorias;
	}

	public void setCategoria(List<CategoriaModel> categoria) {
		this.categorias = categoria;
	}

	@Override
	public String toString() {
		return "DeporteModel [idDeporte=" + idDeporte + ", nombreDeporte=" + nombreDeporte + ", estadoDeporte="
				+ estadoDeporte + "]";
	}

		
	


	
}
