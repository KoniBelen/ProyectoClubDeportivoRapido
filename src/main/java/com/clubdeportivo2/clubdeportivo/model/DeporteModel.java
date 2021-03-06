package com.clubdeportivo2.clubdeportivo.model;


import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name= "deporte")
public class DeporteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_deporte")
	private Integer idDeporte;
	
	@NotBlank(message="Campo obligatorio (*)")
	@Size(min=3, max=150, message="El nombre del deporte debe tener entre 3 a 150 caracteres")
	@Column(name= "nombre_deporte")
	private String nombreDeporte;
	
	@NotNull
	@Column(name="estado")
	private boolean estadoDeporte;
	

	@OneToMany(mappedBy = "deporteCategoria", cascade = CascadeType.ALL)
	private List<CategoriaModel> categorias;
	
	public DeporteModel() {
		
	}

	public DeporteModel(int idDeporte, String nombreDeporte, boolean estadoDeporte) {
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
