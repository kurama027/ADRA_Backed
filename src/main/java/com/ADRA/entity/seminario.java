package com.ADRA.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Seminario")
public class seminario {
	@Id
	 @Column(name = "id_seminario")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idSeminario;
	 
	 @Column(name = "seminarion")
	    private String nomseminario;
	 
	 @Column(name = "des")
	    private String des; 
	 

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

		@Column(name = "seminario_fecha")
	    private Date semiFecha;
	    
	    @Column(name = "seminario_fechafin")
	    private Date semiFechafin;
	    
	    public Date getSemiFechafin() {
			return semiFechafin;
		}

		public void setSemiFechafin(Date semiFechafin) {
			this.semiFechafin = semiFechafin;
		}

		@Column(name = "servicio")
	    private String servicioEspiritual;

		public String getServicioEspiritual() {
			return servicioEspiritual;
		}

		public void setServicioEspiritual(String servicioEspiritual) {
			this.servicioEspiritual = servicioEspiritual;
		}

		public Long getIdSeminario() {
			return idSeminario;
		}

		public void setIdSeminario(Long idSeminario) {
			this.idSeminario = idSeminario;
		}

		
		public String getNomseminario() {
			return nomseminario;
		}

		public void setNomseminario(String nomseminario) {
			this.nomseminario = nomseminario;
		}

		public Date getSemiFecha() {
			return semiFecha;
		}

		public void setSemiFecha(Date semiFecha) {
			this.semiFecha = semiFecha;
		}

		
	    

	
}
