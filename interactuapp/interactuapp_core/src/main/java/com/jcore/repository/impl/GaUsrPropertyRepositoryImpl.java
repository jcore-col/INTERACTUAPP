package com.jcore.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jcore.constantes_sistema.Ga;
import com.jcore.model.entity.GaUser;
import com.jcore.model.entity.GaUsrProperty;
import com.jcore.repository.GaUsrPropertyRepository;

public class GaUsrPropertyRepositoryImpl implements GaUsrPropertyRepository,Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext( unitName = Ga.UNIDAD_PERSISTENCE_JPA)
	private EntityManager em;
	
	@Override
	public void insert(GaUsrProperty p_entity) throws Exception {
		// TODO Auto-generated method stub
		em.persist(p_entity);
	}

	@Override
	public void update(GaUsrProperty p_entity) throws Exception {
		// TODO Auto-generated method stub
		em.merge(p_entity);
	}

	@Override
	public void delete(GaUsrProperty p_entity) throws Exception {
		// TODO Auto-generated method stub
		em.remove(em.merge(p_entity));
	}

	@Override
	public GaUsrProperty buscaPorUsr(String p_cod_usr) throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM GaUsrProperty a WHERE a.codUsr = ?1",GaUsrProperty.class).
				setParameter(1, p_cod_usr).
				getSingleResult();
	}

	@Override
	public GaUsrProperty findById(GaUsrProperty t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GaUsrProperty> findAll() throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM GaUsrProperty a",GaUsrProperty.class).getResultList();
	}


}
