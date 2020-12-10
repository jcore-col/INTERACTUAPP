package com.jcore.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jcore.constantes_sistema.Ga;
import com.jcore.model.entity.CtGeneralTercero;
import com.jcore.model.entity.CtLogPersonRegistry;
import com.jcore.repository.CtGeneralTerceroRepository;
import com.jcore.repository.CtLogPersonRegistryRepository;

public class CtLogPersonRegistryRepositoryImpl implements CtLogPersonRegistryRepository,Serializable{
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext( unitName = Ga.UNIDAD_PERSISTENCE_JPA)
	private EntityManager em;
	@Override
	public void insert(CtLogPersonRegistry t) throws Exception {
		// TODO Auto-generated method stub
		em.persist(t);
	}
	@Override
	public void update(CtLogPersonRegistry t) throws Exception {
		// TODO Auto-generated method stub
		em.merge(t);
	}
	@Override
	public void delete(CtLogPersonRegistry t) throws Exception {
		// TODO Auto-generated method stub
		em.remove(em.merge(t));
	}
	@Override
	public CtLogPersonRegistry findById(CtLogPersonRegistry t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<CtLogPersonRegistry> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CtLogPersonRegistry buscarPorCodDocum(int p_cod_compania, int p_cod_campaign, String p_tip_docum,
			String p_cod_docum) throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM CtLogPersonRegistry a "
				+ "WHERE a.id.codCompania = ?1 "
				+ "AND a.id.codCampaign = ?2"
				+ "AND a.id.codDocum = ?3"
				+ "AND a.id.tipDocum = ?4",CtLogPersonRegistry.class)
				.setParameter(1, p_cod_compania)
				.setParameter(2, p_cod_campaign)
				.setParameter(3, p_cod_docum)
				.setParameter(4, p_tip_docum)
				.getSingleResult();
	}
	
	@Override
	public CtLogPersonRegistry buscarPersonaPorUsr(int p_cod_compania, int p_cod_campaign, String p_tip_docum,
			String p_cod_docum,String p_cod_usr) throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM CtLogPersonRegistry a "
				+ "WHERE a.id.codCompania = ?1 "
				+ "AND a.id.codCampaign = ?2 "
				+ "AND a.id.codDocum = ?3 "
				+ "AND a.id.tipDocum = ?4 "
				+ "AND a.id.codUsr   = ?5",CtLogPersonRegistry.class)
				.setParameter(1, p_cod_compania)
				.setParameter(2, p_cod_campaign)
				.setParameter(3, p_cod_docum)
				.setParameter(4, p_tip_docum)
				.setParameter(5, p_cod_usr)
				.getSingleResult();
	}
	
}
