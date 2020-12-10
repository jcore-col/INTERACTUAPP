package com.jcore.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jcore.constantes_sistema.Ga;
import com.jcore.model.entity.CtGeneralTercero;
import com.jcore.repository.CtGeneralTerceroRepository;

public class CtGeneralTerceroRepositoryImpl implements CtGeneralTerceroRepository,Serializable{
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext( unitName = Ga.UNIDAD_PERSISTENCE_JPA)
	private EntityManager em;
	@Override
	public void insert(CtGeneralTercero p_entity) throws Exception {
		// TODO Auto-generated method stub
		em.persist(p_entity);
	}
	@Override
	public void update(CtGeneralTercero p_entity) throws Exception {
		// TODO Auto-generated method stub
		em.merge(p_entity);
	}
	@Override
	public void delete(CtGeneralTercero p_entity) throws Exception {
		// TODO Auto-generated method stub
		em.remove(em.merge(p_entity));
	}
	@Override
	public CtGeneralTercero findById(CtGeneralTercero t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<CtGeneralTercero> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<CtGeneralTercero> devuelvePersonasPorUsr(int p_cod_compania,int p_cod_campaign, String p_cod_usr) throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM CtGeneralTercero a "
				+ "INNER JOIN CtLogPersonRegistry c ON c.id.codCompania = a.id.codCompania " 
				+ " AND c.id.tipDocum = a.id.tipDocum AND c.id.codDocum = a.id.codDocum "
				+ "WHERE a.id.codCompania = ?1 AND a.id.codActTercero = 1 "
				+ "AND c.id.codUsr = ?2 "
				+ "AND c.id.codCampaign = ?3 "
				+ "AND a.mcaInh = 'N' "
				+ "AND a.id.fecValidez = (SELECT MAX(b.id.fecValidez) FROM CtGeneralTercero b "
				+ "WHERE b.id.codCompania = a.id.codCompania AND b.id.tipDocum = a.id.tipDocum AND b.id.codDocum = a.id.codDocum "
				+ "AND b.id.codActTercero = a.id.codActTercero)",CtGeneralTercero.class)
				.setParameter(1, p_cod_compania)
				.setParameter(2, p_cod_usr)
				.setParameter(3, p_cod_campaign)
				.getResultList()
				;
	}
	@Override
	public List<CtGeneralTercero> devuelvePersonasPorCia(int p_cod_compania,int p_cod_campaign) throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM CtGeneralTercero a "
				+ "INNER JOIN CtLogPersonRegistry c ON c.id.codCompania = a.id.codCompania "
				+ "AND c.id.tipDocum = a.id.tipDocum AND c.id.codDocum = a.id.codDocum "
				+ "WHERE a.id.codCompania = ?1 AND a.id.codActTercero = 1 "
				+ "AND c.id.codCampaign = ?2 "
				+ "AND a.mcaInh = 'N' "
				+ "AND a.id.fecValidez = (SELECT MAX(b.id.fecValidez) FROM CtGeneralTercero b "
				+ "WHERE b.id.codCompania = a.id.codCompania AND b.id.tipDocum = a.id.tipDocum AND b.id.codDocum = a.id.codDocum "
				+ "AND b.id.codActTercero = a.id.codActTercero)",CtGeneralTercero.class)
				.setParameter(1, p_cod_compania)
				.setParameter(2, p_cod_campaign)
				.getResultList()
				;
	}
	@Override
	public CtGeneralTercero devuelvePersonaPorDocum(int p_cod_compania, String p_tip_docum, String p_cod_docum) throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM CtGeneralTercero a "
				+ "WHERE a.id.codCompania = ?1 and a.id.tipDocum = ?2 "
				+ "AND a.id.codDocum = ?3 AND a.id.codActTercero = 1 "
				+ "AND a.mcaInh = 'N' "
				+ "AND a.id.fecValidez = (SELECT MAX(b.id.fecValidez) FROM CtGeneralTercero b "
				+ "WHERE b.id.codCompania = a.id.codCompania AND b.id.tipDocum = a.id.tipDocum AND b.id.codDocum = a.id.codDocum "
				+ "AND b.id.codActTercero = a.id.codActTercero)",CtGeneralTercero.class)
				.setParameter(1, p_cod_compania)
				.setParameter(2, p_tip_docum)
				.setParameter(3, p_cod_docum)
				.getSingleResult();
	}
}
