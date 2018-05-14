package com.ibm.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TPED_DETALLE")
public class EDetalle implements Serializable {
	private static final long serialVersionUID = 8255845086445928845L;

	@Id
	@GeneratedValue
	@Column(name="CDID", nullable=false)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CDPEDIDO")
	private EPedido pedido;
	
	@OneToOne
	@JoinColumn(name = "CDTIPO_PRENDA", referencedColumnName = "DSPARAMETRO")
	private EParametro tipoPrenda;
	
	@Column(name="NMCANTIDAD", nullable=true)
	private String cantidad;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EPedido getPedido() {
		return pedido;
	}

	public void setPedido(EPedido pedido) {
		this.pedido = pedido;
	}

	public EParametro getTipoPrenda() {
		return tipoPrenda;
	}

	public void setTipoPrenda(EParametro tipoPrenda) {
		this.tipoPrenda = tipoPrenda;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	
	public static String nombreEntidad() {
		return "TPED_DETALLE";
	}

}
