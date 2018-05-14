package com.ibm.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TVIEW_TIPO_DOCUMENTO")
public class ETipoIdentificacion implements Serializable{
	private static final long serialVersionUID = 7627918389123003805L;

	@Id
	@Column(name="CDID", nullable=false)
	private int id;
	
	@Column(name="DSPARAMETRO")
	private String codigoTipoId;
	
	@Column(name="DSVALOR")
	private String tipoIdentificacion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigoTipoId() {
		return codigoTipoId;
	}

	public void setCodigoTipoId(String codigoTipoId) {
		this.codigoTipoId = codigoTipoId;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
}
