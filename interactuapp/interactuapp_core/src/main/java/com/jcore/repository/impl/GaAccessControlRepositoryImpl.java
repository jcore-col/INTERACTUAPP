package com.jcore.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jcore.constantes_sistema.Ga;
import com.jcore.model.entity.GaAccessControl;
import com.jcore.repository.GaAccessControlRepository;

public class GaAccessControlRepositoryImpl implements GaAccessControlRepository,Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext( unitName = Ga.UNIDAD_PERSISTENCE_JPA)
	private EntityManager em;
	
	@Override
	public void insert(GaAccessControl p_entity) throws Exception {
		// TODO Auto-generated method stub
		em.persist(p_entity);
	}

	@Override
	public void update(GaAccessControl p_entity) throws Exception {
		// TODO Auto-generated method stub
		em.merge(p_entity);
	}

	@Override
	public void delete(GaAccessControl p_entity) throws Exception {
		// TODO Auto-generated method stub
		em.remove(p_entity);
	}


	@Override
	public GaAccessControl findById(GaAccessControl t) throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM ga_acces_control a WHERE a.cod_usr = ?"
				+ "AND a.cod_rol = ?"
				,GaAccessControl.class).
				setParameter(1, t.getId().getCodUsr()).
				setParameter(2, t.getId().getCodRol()).
				getSingleResult();
	}

	@Override
	public List<GaAccessControl> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
