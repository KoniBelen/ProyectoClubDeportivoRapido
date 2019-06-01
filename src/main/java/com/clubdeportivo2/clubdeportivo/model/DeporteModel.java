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
	private int idDeporte;
	
	@NotNull
	@Column(name= "nombre_deporte")
	private String nombreDeporte;
	
	@NotNull
	@Column(name="estado")
	private boolean estadoDeporte;
	

	@OneToMany(cascade= CascadeType.MERGE, mappedBy = "idCategoria", fetch = FetchType.EAGER)
	//@JoinColumn(name="id_categoria")
	private List<CategoriaModel> categoria;
	
	
	
	public DeporteModel() {
		
	}

	public DeporteModel(int idDeporte, String nombreDeporte, boolean estadoDeporte) {
		super();
		this.idDeporte = idDeporte;
		this.nombreDeporte = nombreDeporte;
		this.estadoDeporte=estadoDeporte;
	}

	public int getIdDeporte() {
		return idDeporte;
	}

	public void setIdDeporte(int idDeporte) {
		this.idDeporte = idDeporte;
	}

	public String getNombreDeporte() {
		return nombreDeporte;
	}

	public void setNombreDeporte(String nombreDeporte) {
		this.nombreDeporte = nombreDeporte;
	}

	public boolean getEstadoDeporte() {
		return estadoDeporte;
	}

	public void setEstadoDeporte(boolean estadoDeporte) {
		this.estadoDeporte = estadoDeporte;
	}


	public List<CategoriaModel> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<CategoriaModel> categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "DeporteModel [idDeporte=" + idDeporte + ", nombreDeporte=" + nombreDeporte + ", estadoDeporte="
				+ estadoDeporte + ", categoria=" + categoria + "]";
	}

		
	


	
}
