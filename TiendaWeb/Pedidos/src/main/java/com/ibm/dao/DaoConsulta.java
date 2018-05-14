package com.ibm.dao;

import static com.ibm.utils.Constantes.MANAGER_FACTORY;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DaoConsulta<E> implements IDaoConsulta<E> {

	protected EntityManager entityManager;
	protected String nombreEntidad;
	
	public DaoConsulta(String nombreEntidad){
		this.nombreEntidad = nombreEntidad;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(MANAGER_FACTORY);
		entityManager = emf.createEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E consultarId(int id) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT entidad ");
		sb.append("FROM ").append(nombreEntidad).append(" entidad ");
		sb.append("WHERE id = :codigo");
		
		Query query = entityManager.createQuery(sb.toString());
		query.setParameter("codigo", id);
		
		return (E) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> consultarTodo() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT entidad ");
		sb.append("FROM ").append(nombreEntidad).append(" entidad");
		
		Query query = entityManager.createQuery(sb.toString());
		
		return (List<E>) query.getResultList();
	}	
}
