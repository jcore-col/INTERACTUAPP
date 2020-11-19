package com.jcore.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jcore.constantes_sistema.Ga;
import com.jcore.model.entity.GaRole;
import com.jcore.repository.GaRoleRepository;

public class GaRoleRepositoryImpl implements GaRoleRepository,Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext( unitName = Ga.UNIDAD_PERSISTENCE_JPA)
	private EntityManager em;

	@Override
	public void insert(GaRole t) throws Exception {
		// TODO Auto-generated method stub
		em.persist(t);
	}

	@Override
	public void update(GaRole t) throws Exception {
		// TODO Auto-generated method stub
		em.merge(t);
	}

	@Override
	public void delete(GaRole t) throws Exception {
		// TODO Auto-generated method stub
		em.remove(em.merge(t));
	}

	@Override
	public GaRole findById(GaRole t) throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM GaRole a WHERE a.codRol = ?1",GaRole.class)
				.setParameter(1, t.getCodRol()).getSingleResult();
	}

	@Override
	public List<GaRole> findAll() throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM GaRole a",GaRole.class)
				.getResultList();
	}
	
	
}
