package com.clubdeportivo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
@Table(name="cuotas")
public class CuotasModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cuotas")
	private int idCategoria;

	
	@NotNull
	@Column(name="f_de_pago")
	private Date fechaDePago;
	
	@NotNull
	@Column(name="mes")
	private int mes;
	
	@NotNull
	@Column(name="anio")
	private int anio;
	
	@OneToMany(cascade= CascadeType.MERGE, mappedBy = "socio", fetch = FetchType.EAGER)
	@JoinColumn(name="id_socio")
	private List<SocioModel> socio;

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Date getFechaDePago() {
		return fechaDePago;
	}

	public void setFechaDePago(Date fechaDePago) {
		this.fechaDePago = fechaDePago;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public List<SocioModel> getSocio() {
		return socio;
	}

	public void setSocio(List<SocioModel> socio) {
		this.socio = socio;
	}

	@Override
	public String toString() {
		return "CuotasModel [idCategoria=" + idCategoria + ", fechaDePago=" + fechaDePago + ", mes=" + mes + ", anio="
				+ anio + ", socio=" + socio + "]";
	}
	
	
	
	
}
