package com.ibm.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.ibm.pojo.Pedido;
import com.ibm.pojo.Respuesta;
import com.ibm.servicios.PersistirPedido;

@Path("/persistir")
public class Persistir {
	
	private PersistirPedido persistirPedido;
	
	@POST
	@Path("/pedido")
	@Produces(MediaType.APPLICATION_JSON)
	public Respuesta prueba(@QueryParam("pedido")String pedido){
		Gson gson = new Gson();
		persistirPedido = new PersistirPedido();
		return persistirPedido.guardarPedido(gson.fromJson(pedido, Pedido.class));
	}

}
