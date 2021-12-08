package com.ADRA.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "servicio_espiritual")

public class servicioespiritual {
	
	@Id
	 @Column(name = "idservicio_esp")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idServicioEsp;
	 
	@Column(name = "meditacion")
    private Date mediFecha;

	@Column(name = "oracion")
    private String oracion;

	
	public String getOracion() {
		return oracion;
	}

	public void setOracion(String oracion) {
		this.oracion = oracion;
	}

	public Long getIdServicioEsp() {
		return idServicioEsp;
	}

	public void setIdServicioEsp(Long idServicioEsp) {
		this.idServicioEsp = idServicioEsp;
	}

	public Date getMediFecha() {
		return mediFecha;
	}

	public void setMediFecha(Date mediFecha) {
		this.mediFecha = mediFecha;
	}
    
}
