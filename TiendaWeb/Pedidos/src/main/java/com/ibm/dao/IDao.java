package com.ibm.dao;

public interface IDao<E> extends IDaoConsulta<E> {

	public void insertar(E entidad);
	public void actualizar(E entidad);
	public void eliminar(E entidad);
}
