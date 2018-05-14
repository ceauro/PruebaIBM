package com.ibm.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TPED_PARAMETROS")
public class EParametro implements Serializable {
	private static final long serialVersionUID = 7504601466275834117L;

	@Id
	@GeneratedValue
	@Column(name="CDID", nullable=false)
	private int id;
	
	@Column(name="CDPARAMETRO", nullable=true)
	private String tipoParametro;
	
	@Column(name="DSPARAMETRO", nullable=true)
	private String parametro;
	
	@Column(name="DSVALOR", nullable=true)
	private String valor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoParametro() {
		return tipoParametro;
	}

	public void setTipoParametro(String tipoParametro) {
		this.tipoParametro = tipoParametro;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public static String nombreEntidad() {
		return "TPED_PARAMETROS";
	}
}
