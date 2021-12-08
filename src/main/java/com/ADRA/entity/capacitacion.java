package com.ADRA.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "capacitaciones")
public class capacitacion {
	 @Id
	 @Column(name = "id_capaciatacion")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idCapacitacion;
	 
	 @Column(name = "capaciatacion")
	    private String nomCapaciatacion;

	    @Column(name = "modulos")
	    private String modulos;

	    @Column(name = "sesiones")
	    private Long sesiones;
	    
	    @Column(name = "materiales")
	    private String materiales;

	    public Long getIdCapacitacion() {
			return idCapacitacion;
		}

		public Long getSesiones() {
			return sesiones;
		}

		public void setSesiones(Long sesiones) {
			this.sesiones = sesiones;
		}

		public void setIdCapacitacion(Long idCapacitacion) {
			this.idCapacitacion = idCapacitacion;
		}

		public String getNomCapaciatacion() {
			return nomCapaciatacion;
		}

		

		public void setNomCapaciatacion(String nomCapaciatacion) {
			this.nomCapaciatacion = nomCapaciatacion;
		}

		public String getModulos() {
			return modulos;
		}

		public void setModulos(String modulos) {
			this.modulos = modulos;
		}

		

		public String getMateriales() {
			return materiales;
		}

		public void setMateriales(String materiales) {
			this.materiales = materiales;
		}

		public Date getCapaFecha() {
			return capaFecha;
		}

		public void setCapaFecha(Date capaFecha) {
			this.capaFecha = capaFecha;
		}

		@Column(name = "capa_fecha")
	    private Date capaFecha;

	
	    
}
