package com.ibm.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ibm.dao.DaoConsulta;
import com.ibm.dao.IDaoConsulta;
import com.ibm.entidades.ETipoIdentificacion;
import com.ibm.entidades.ETipoPrendas;

@Path("/consulta")
public class Consulta {
	
	@GET
	@Path("/prendas")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, String> consultarTipoPrendas(){
		Map<String, String> prendas = new HashMap<>();
		IDaoConsulta<ETipoPrendas> dao = new DaoConsulta<>(ETipoPrendas.class.getSimpleName());
		List<ETipoPrendas> listado = dao.consultarTodo(); 
		
		for(ETipoPrendas parametro : listado){
			prendas.put(parametro.getCodigoTipoPrenda(), parametro.getTipoPrenda());
		}
		
		return prendas;
	}
	
	@GET
	@Path("/identificacion")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, String> consultarTipoIdentificacion(){
		Map<String, String> ids = new HashMap<>();
		IDaoConsulta<ETipoIdentificacion> dao = new DaoConsulta<>(ETipoIdentificacion.class.getSimpleName());
		List<ETipoIdentificacion> listado = dao.consultarTodo(); 
		
		for(ETipoIdentificacion parametro : listado){
			ids.put(parametro.getCodigoTipoId(), parametro.getTipoIdentificacion());
		}
		
		return ids;
	}

}
