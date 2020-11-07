package com.jcore.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jcore.constantes_sistema.Ga;
import com.jcore.model.entity.GaUsrGroupMember;
import com.jcore.model.entity.GaUsrGroupMemberPK;
import com.jcore.repository.GaUsrGroupMemberRepository;

public class GaUsrGroupMemberRepositoryImpl implements GaUsrGroupMemberRepository,Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext( unitName = Ga.UNIDAD_PERSISTENCE_JPA)
	private EntityManager em;
	
	@Override
	public void insert(GaUsrGroupMember p_entity) throws Exception {
		// TODO Auto-generated method stub
		em.persist(p_entity);
	}

	@Override
	public void update(GaUsrGroupMember p_entity) throws Exception {
		// TODO Auto-generated method stub
		em.merge(p_entity);
	}

	@Override
	public void delete(GaUsrGroupMember p_entity) throws Exception {
		// TODO Auto-generated method stub
		em.remove(p_entity);
	}

	@Override
	public GaUsrGroupMember findById(GaUsrGroupMember t) throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM ga_usr_group_member a WHERE a.cod_usr = ?"
				+ "AND a.cod_grp_usr = ? AND a.cod_compania = ?"
				,GaUsrGroupMember.class).
				setParameter(1, t.getId().getCodUsr()).
				setParameter(2, t.getId().getCodGrpUsr()).
				setParameter(3, t.getId().getCodCompania()).
				getSingleResult();
	}

	@Override
	public List<GaUsrGroupMember> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
