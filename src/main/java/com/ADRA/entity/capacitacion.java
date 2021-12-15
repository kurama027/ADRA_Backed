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
	
	private String name;
    private String url;
	
    public capacitacion() {
    }
    
    public capacitacion(String name, String url) {
    }
    
	 public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Id
	 @Column(name = "id_capaciatacion")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idCapacitacion;
	 
	 @Column(name = "capaciatacion")
	    private String nomCapaciatacion;

	    @Column(name = "modulos")
	    private String modulos;

	    @Column(name = "sesiones")
	    private String sesiones;
	    
	    @Column(name = "capa_fecha")
	    private Date capaFecha;

		@Column(name = "capa_fechafin")
	    private Date capaFechafin;

		@Column(name = "materiales")
	    private String materiales;
		
		

		public Long getIdCapacitacion() {
			return idCapacitacion;
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

		public String getSesiones() {
			return sesiones;
		}

		public void setSesiones(String sesiones) {
			this.sesiones = sesiones;
		}

		public Date getCapaFecha() {
			return capaFecha;
		}

		public void setCapaFecha(Date capaFecha) {
			this.capaFecha = capaFecha;
		}

		public Date getCapaFechafin() {
			return capaFechafin;
		}

		public void setCapaFechafin(Date capaFechafin) {
			this.capaFechafin = capaFechafin;
		}

		public String getMateriales() {
			return materiales;
		}

		public void setMateriales(String materiales) {
			this.materiales = materiales;
		}
 
	 

}
