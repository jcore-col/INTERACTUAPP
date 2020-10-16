package com.jcore.clases_mantenimiento_entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jcore.constantes_sistema.Ga;
import com.jcore.model.entity.GaUsrGroupMember;
import com.jcore.model.entity.GaUsrGroupMemberPK;
import com.jcore.repository.Ga_Int_UsrGroupMember;

public class Ga_Class_UsrGroupMember implements Ga_Int_UsrGroupMember,Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext( unitName = Ga.unidadPersistenceJpa)
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
	public List<GaUsrGroupMember> devuelveTodos() throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM ga_usr_group_member a",GaUsrGroupMember.class).getResultList();
	}

	@Override
	public GaUsrGroupMember buscaPorLLaveTabla(GaUsrGroupMemberPK p_id) throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM ga_usr_group_member a WHERE a.cod_usr = ?"
				+ "AND a.cod_grp_usr = ? AND a.cod_compania = ?"
				,GaUsrGroupMember.class).
				setParameter(1, p_id.getCodUsr()).
				setParameter(2, p_id.getCodGrpUsr()).
				setParameter(3, p_id.getCodCompania()).
				getSingleResult();
	}
}
