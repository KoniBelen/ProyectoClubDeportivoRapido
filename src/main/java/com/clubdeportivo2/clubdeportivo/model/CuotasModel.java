package com.clubdeportivo2.clubdeportivo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import java.sql.Date;
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
	@Column(name="monto_cuota")
	private int cuota;
	
	@ManyToOne
	@JoinColumn(name="id_socio")
	private SocioModel idSocio;

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

	public int getCuota() {
		return cuota;
	}

	public void setCuota(int cuota) {
		this.cuota = cuota;
	}


	public SocioModel getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(SocioModel idSocio) {
		this.idSocio = idSocio;
	}

	@Override
	public String toString() {
		return "CuotasModel [idCategoria=" + idCategoria + ", fechaDePago=" + fechaDePago + ", cuota=" + cuota
				+ ", idSocio=" + idSocio + "]";
	}

	
	
	
	
}
