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
	    private String Seminario;

	    @Column(name = "seminario_fecha")
	    private Date semiFecha;
	    
	    @Column(name = "servicio")
	    private String ServicioEspiritual;

		public Long getIdSeminario() {
			return idSeminario;
		}

		public void setIdSeminario(Long idSeminario) {
			this.idSeminario = idSeminario;
		}

		public String getSeminario() {
			return Seminario;
		}

		public void setSeminario(String seminario) {
			Seminario = seminario;
		}

		public Date getSemiFecha() {
			return semiFecha;
		}

		public void setSemiFecha(Date semiFecha) {
			this.semiFecha = semiFecha;
		}

		public String getServicioEspiritual() {
			return ServicioEspiritual;
		}

		public void setServicioEspiritual(String servicioEspiritual) {
			ServicioEspiritual = servicioEspiritual;
		}
	    

	
}
