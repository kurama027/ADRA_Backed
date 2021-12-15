package com.ADRA.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "banco")
public class banco {
	
	@Id
	@Column(name = "id_banco")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idbanco;
	
	@Column(name = "nom_banco")
    private String nombanco; 
	
	@Column(name = "sede")
    private String sede;

	public long getIdbanco() {
		return idbanco;
	}

	public void setIdbanco(long idbanco) {
		this.idbanco = idbanco;
	}

	public String getNombanco() {
		return nombanco;
	}

	public void setNombanco(String nombanco) {
		this.nombanco = nombanco;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	} 
	
	
}
