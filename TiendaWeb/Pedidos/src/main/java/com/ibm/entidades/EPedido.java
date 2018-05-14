package com.ibm.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TPED_PEDIDO")
public class EPedido implements Serializable {
	private static final long serialVersionUID = 5332437078569429520L;

	@Id
	@GeneratedValue
	@Column(name="CDID", nullable=false)
	private int id;
	
	@Column(name="DSNOMBRE", nullable=false)
	private String nombre;
	
	@OneToOne
	@JoinColumn(name="CDTIPO_ID", referencedColumnName = "DSPARAMETRO")
	private EParametro tipoId;
	
	@Column(name="NMIDENTIFICACION", nullable=false)
	private String identificacion;
	
	@Column(name="FEENTREGA", nullable=false)
	private String fechaEntrega;
	
	@Column(name="DSDIRECCION", nullable=false)
	private String direccion;
	
	@Column(name="NMVALOR", nullable=false)
	private String valor;
	
	@OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<EDetalle> detalles;

	public List<EDetalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<EDetalle> detalles) {
		this.detalles = detalles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public EParametro getTipoId() {
		return tipoId;
	}

	public void setTipoId(EParametro tipoId) {
		this.tipoId = tipoId;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public static String nombreEntidad() {
		return "TPED_PEDIDO";
	}
	
}
