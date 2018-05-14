package com.ibm.dao;

import javax.persistence.Query;

import com.ibm.entidades.EParametro;

public class DaoParametro extends DaoConsulta<EParametro>{

	public DaoParametro() {
		super(EParametro.class.getSimpleName());
	}
	
	public EParametro consultarParametro(String parametro) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT entidad ");
		sb.append("FROM ").append(nombreEntidad).append(" entidad ");
		sb.append("WHERE entidad.parametro = :codigo");
		
		Query query = entityManager.createQuery(sb.toString());
		query.setParameter("codigo", parametro);
		
		return (EParametro) query.getSingleResult();
	}

}
