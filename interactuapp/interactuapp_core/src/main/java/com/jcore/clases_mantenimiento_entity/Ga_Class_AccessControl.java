package com.jcore.clases_mantenimiento_entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jcore.constantes_sistema.Ga;
import com.jcore.model.entity.GaAccessControl;
import com.jcore.model.entity.GaAccessControlPK;
import com.jcore.repository.Ga_Int_AccessControl;

public class Ga_Class_AccessControl implements Ga_Int_AccessControl,Serializable{
	
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
	public List<GaAccessControl> devuelveTodos() throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM ga_acces_control a",GaAccessControl.class).getResultList();
	}

	@Override
	public GaAccessControl buscaPorLLaveTabla(GaAccessControlPK p_id) throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM ga_acces_control a WHERE a.cod_usr = ?"
				+ "AND a.cod_rol = ?"
				,GaAccessControl.class).
				setParameter(1, p_id.getCodUsr()).
				setParameter(2, p_id.getCodRol()).
				getSingleResult();
	}
}