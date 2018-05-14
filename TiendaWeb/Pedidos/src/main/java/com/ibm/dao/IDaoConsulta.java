package com.ibm.dao;

import java.util.List;

public interface IDaoConsulta<E> {
	
	public E consultarId(int id);
	public List<E> consultarTodo();
}
