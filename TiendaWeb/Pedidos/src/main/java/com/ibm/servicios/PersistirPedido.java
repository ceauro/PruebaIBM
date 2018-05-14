package com.ibm.servicios;

import java.util.ArrayList;
import java.util.List;

import com.ibm.dao.Dao;
import com.ibm.dao.DaoParametro;
import com.ibm.entidades.EDetalle;
import com.ibm.entidades.EParametro;
import com.ibm.entidades.EPedido;
import com.ibm.pojo.Detalle;
import com.ibm.pojo.Pedido;
import com.ibm.pojo.Respuesta;

public class PersistirPedido {
	
	private Dao<EPedido> dao;
	
	public Respuesta guardarPedido(Pedido pedido){
		dao = new Dao<EPedido>(EPedido.class.getSimpleName());
		Respuesta ans = new Respuesta();
		EPedido entidad = new EPedido();
		List<EDetalle> detalles = new ArrayList<>();
		
		entidad.setNombre(pedido.getNombre());
		entidad.setIdentificacion(pedido.getIdentificacion());
		entidad.setTipoId(getParametro(pedido.getTipoId()));
		entidad.setDireccion(pedido.getDireccion());
		entidad.setFechaEntrega(pedido.getFechaEntrega());
		entidad.setValor(pedido.getValor());
		
		for(Detalle det : pedido.getDetalles()){
			EDetalle detalle = new EDetalle();
			detalle.setPedido(entidad);
			detalle.setTipoPrenda(getParametro(det.getTipoPrenda()));
			detalle.setCantidad(det.getCantidad());
			detalles.add(detalle);
		}
		
		entidad.setDetalles(detalles);
		
		try{
			dao.insertar(entidad);
			ans.setOk(true);
		} catch(Exception e){
			ans.setOk(false);
			ans.setErrorTecnico(e.getMessage());
			ans.setError("Ocurrió un error guardando el pedido");
		}
		
		return ans;
	}
	
	private EParametro getParametro(String parametro){
		DaoParametro daoParametro = new DaoParametro();
		EParametro param = daoParametro.consultarParametro(parametro);
		return param;
	}
}
