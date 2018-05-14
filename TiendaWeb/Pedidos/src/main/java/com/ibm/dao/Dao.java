package com.ibm.dao;

import static com.ibm.utils.Constantes.MANAGER_FACTORY;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Dao<E> implements IDao<E> {
	
	private EntityManagerFactory emf;
	protected EntityManager entityManager;
	protected String nombreEntidad;

	public Dao(String nombreEntidad) {
		this.nombreEntidad = nombreEntidad;
		emf = Persistence.createEntityManagerFactory(MANAGER_FACTORY);
		entityManager = emf.createEntityManager();
	}

	@Override
	public void insertar(E entidad) {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			entityManager.persist(entidad);
			trans.commit();
		} catch (Exception e) {
			if (trans != null && trans.isActive()) {
				trans.rollback();
			}
			throw e;
		}
	}

	@Override
	public void actualizar(E entidad) {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			entityManager.merge(entidad);
			trans.commit();
		} catch (Exception e) {
			if (trans != null && trans.isActive()) {
				trans.rollback();
			}
			throw e;
		}
	}

	@Override
	public void eliminar(E entidad) {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			entityManager.remove(entidad);
			trans.commit();
		} catch (Exception e) {
			if (trans != null && trans.isActive()) {
				trans.rollback();
			}
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E consultarId(int id) {
		StringBuilder sb = new StringBuilder();

		sb.append("SELECT entidad ");
		sb.append("FROM ").append(nombreEntidad).append(" entidad");
		sb.append("WHERE CDID = :codigo");

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
