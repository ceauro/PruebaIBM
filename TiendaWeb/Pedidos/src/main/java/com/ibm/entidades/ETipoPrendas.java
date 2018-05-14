package com.ibm.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TVIEW_TIPO_PRENDA")
public class ETipoPrendas implements Serializable{
	private static final long serialVersionUID = -7289904838608811624L;

	@Id
	@GeneratedValue
	@Column(name="CDID", nullable=false)
	private int id;
	
	@Column(name="DSPARAMETRO")
	private String codigoTipoPrenda;
	
	@Column(name="DSVALOR")
	private String tipoPrenda;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigoTipoPrenda() {
		return codigoTipoPrenda;
	}

	public void setCodigoTipoPrenda(String codigoTipoPrenda) {
		this.codigoTipoPrenda = codigoTipoPrenda;
	}

	public String getTipoPrenda() {
		return tipoPrenda;
	}

	public void setTipoPrenda(String tipoPrenda) {
		this.tipoPrenda = tipoPrenda;
	}
}
