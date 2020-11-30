package com.jcore.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jcore.constantes_sistema.Ga;
import com.jcore.model.entity.GaLocalidad;
import com.jcore.repository.GaLocalidadRepository;

public class GaLocalidadRepositoryImpl implements GaLocalidadRepository,Serializable{
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext( unitName = Ga.UNIDAD_PERSISTENCE_JPA)
	private EntityManager em;
	
	
	@Override
	public List<GaLocalidad> findAll() throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM GaLocalidad a",GaLocalidad.class).getResultList();
	}


	@Override
	public void insert(GaLocalidad t) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(GaLocalidad t) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void delete(GaLocalidad t) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public GaLocalidad findById(GaLocalidad t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}
