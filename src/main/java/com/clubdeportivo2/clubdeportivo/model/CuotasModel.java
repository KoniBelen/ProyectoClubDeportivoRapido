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

	private Integer idCuota;


	
	@NotNull
	@Column(name="f_de_pago")
	private Date fechaDePago;
	
	@NotNull
	@Column(name="monto_cuota")
	private int montoCuota;
	
	@ManyToOne
	@JoinColumn(name="id_socio")
	private SocioModel socioCuota;


	public Integer getIdCuota() {
		return idCuota;
	}

	public void setIdCuota(Integer idCuota) {
		this.idCuota = idCuota;

	}

	public Date getFechaDePago() {
		return fechaDePago;
	}

	public void setFechaDePago(Date fechaDePago) {
		this.fechaDePago = fechaDePago;
	}

	public int getMontoCuota() {
		return montoCuota;
	}

	public void setMontoCuota(int montoCuota) {
		this.montoCuota = montoCuota;
	}

	public SocioModel getSocioCuota() {
		return socioCuota;
	}

	public void setSocioCuota(SocioModel socioCuota) {
		this.socioCuota = socioCuota;
	}

	@Override
	public String toString() {

		return "CuotasModel [idCuota=" + idCuota + ", fechaDePago=" + fechaDePago + ", montoCuota=" + montoCuota
				+ ", socioCuota=" + socioCuota + "]";

	}

	
	


	

	
	
	
	
}
