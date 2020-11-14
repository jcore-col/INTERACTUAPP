package com.jcore.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jcore.constantes_sistema.Ga;
import com.jcore.model.entity.GaUser;
import com.jcore.repository.GaUserRepository;

public class GaUserRepositoryImpl implements GaUserRepository,Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext( unitName = Ga.UNIDAD_PERSISTENCE_JPA)
	private EntityManager em;
	
	@Override
	public void insert(GaUser p_entity) throws Exception {
		// TODO Auto-generated method stub
		em.persist(p_entity);
	}

	@Override
	public void update(GaUser p_entity) throws Exception {
		// TODO Auto-generated method stub
		em.merge(p_entity);
	}

	@Override
	public void delete(GaUser p_entity) throws Exception {
		// TODO Auto-generated method stub
		em.remove(em.merge(p_entity));
	}


	@Override
	public GaUser findById(GaUser p_entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GaUser buscaPorUsr(String p_cod_usr) throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM GaUser a WHERE a.codUsr = ?1",GaUser.class)
				.setParameter(1, p_cod_usr)
				.getSingleResult();
	}

	@Override
	public List<GaUser> findAll() throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM GaUser a",GaUser.class).getResultList();
	}

}
