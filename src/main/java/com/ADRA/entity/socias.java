package com.ADRA.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "socias")
public class socias {

	@Id
	 @Column(name = "id_socias")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long idSocias;
	 
	 @Column(name = "nombre")
	    private String Nombre;
	 
	 @Column(name = "apellido")
	    private String Apellido;

	    @Column(name = "dni")
	    private Long DNI; 
	    

		public Long getIdSocias() {
			return idSocias;
		}

		public void setIdSocias(Long idSocias) {
			this.idSocias = idSocias;
		}

		public String getNombre() {
			return Nombre;
		}

		public void setNombre(String nombre) {
			Nombre = nombre;
		}

		public String getApellido() {
			return Apellido;
		}

		public void setApellido(String apellido) {
			Apellido = apellido;
		}

		public Long getDNI() {
			return DNI;
		}

		public void setDNI(Long dNI) {
			DNI = dNI;
		}

	    
}
