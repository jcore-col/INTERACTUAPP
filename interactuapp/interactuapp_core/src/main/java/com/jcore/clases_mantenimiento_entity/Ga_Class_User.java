package com.jcore.clases_mantenimiento_entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jcore.constantes_sistema.Ga;
import com.jcore.model.entity.GaUser;
import com.jcore.repository.Ga_Int_User;

public class Ga_Class_User implements Ga_Int_User,Serializable{
	
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
		em.remove(p_entity);
	}

	@Override
	public List<GaUser> devuelveTodos() throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM ga_user a",GaUser.class).getResultList();
	}

	@Override
	public GaUser buscaPorLLaveTabla(String p_cod_usr) throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM ga_user a WHERE a.cod_usr = ?",GaUser.class).
				setParameter(1, p_cod_usr).
				getSingleResult();
	}

}
