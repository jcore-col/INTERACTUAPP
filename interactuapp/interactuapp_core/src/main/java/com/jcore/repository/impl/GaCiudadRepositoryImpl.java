package com.jcore.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jcore.constantes_sistema.Ga;
import com.jcore.model.entity.GaCiudad;
import com.jcore.model.entity.GaLocalidad;
import com.jcore.repository.GaCiudadRepository;
import com.jcore.repository.GaLocalidadRepository;

public class GaCiudadRepositoryImpl implements GaCiudadRepository,Serializable{
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext( unitName = Ga.UNIDAD_PERSISTENCE_JPA)
	private EntityManager em;
	@Override
	public void insert(GaCiudad t) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(GaCiudad t) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(GaCiudad t) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public GaCiudad findById(GaCiudad t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<GaCiudad> findAll() throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM GaCiudad a",GaCiudad.class).getResultList();
	}
	
	

	

}
