package com.jcore.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jcore.constantes_sistema.Ga;
import com.jcore.model.entity.GaProfesion;
import com.jcore.repository.GaProfesionRepository;

public class GaProfesionRepositoryImpl implements GaProfesionRepository,Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext( unitName = Ga.UNIDAD_PERSISTENCE_JPA)
	private EntityManager em;

	@Override
	public void insert(GaProfesion t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GaProfesion t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(GaProfesion t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GaProfesion findById(GaProfesion t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GaProfesion> findAll() throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM GaProfesion a",GaProfesion.class).getResultList();
	}
	
	

}
