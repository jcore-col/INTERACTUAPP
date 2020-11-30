package com.jcore.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jcore.constantes_sistema.Ga;
import com.jcore.model.entity.GaEstado;
import com.jcore.repository.GaEstadoRepository;

public class GaEstadoRepositoryImpl implements GaEstadoRepository,Serializable{
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext( unitName = Ga.UNIDAD_PERSISTENCE_JPA)
	private EntityManager em;
	
	
	@Override
	public List<GaEstado> findAll() throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM GaEstado a",GaEstado.class).getResultList();
	}


	@Override
	public void insert(GaEstado t) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(GaEstado t) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(GaEstado t) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public GaEstado findById(GaEstado t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
