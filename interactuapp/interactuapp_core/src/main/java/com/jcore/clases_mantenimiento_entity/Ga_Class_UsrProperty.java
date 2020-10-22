package com.jcore.clases_mantenimiento_entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jcore.constantes_sistema.Ga;
import com.jcore.model.entity.GaUser;
import com.jcore.model.entity.GaUsrProperty;
import com.jcore.repository.Ga_Int_User;
import com.jcore.repository.Ga_Int_UsrProperty;

public class Ga_Class_UsrProperty implements Ga_Int_UsrProperty,Serializable{
	
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
		em.remove(p_entity);
	}

	@Override
	public List<GaUsrProperty> devuelveTodos() throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM ga_usr_property a",GaUsrProperty.class).getResultList();
	}

	@Override
	public GaUsrProperty buscaPorLLaveTabla(String p_cod_usr) throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM ga_usr_property a WHERE a.cod_usr = ?",GaUsrProperty.class).
				setParameter(1, p_cod_usr).
				getSingleResult();
	}


}
