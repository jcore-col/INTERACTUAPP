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
	public List<CtGeneralTercero> devuelvePersonasPorUsr(int p_cod_compania, String p_cod_usr) throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM CtGeneralTercero a "
				+ "INNER JOIN CtLogPersonRegistry c ON c.codCompania = a.codCompania "
				+ "AND c.tipDocum = a.tipDocum AND c.codDocum = a.codDocum "
				+ "WHERE a.codCompania = ?1 AND a.codActTercero = 1 "
				+ "AND c.codUsr = ?2 "
				+ "AND a.fecValidez = (SELECT MAX(b.fecValidez) FROM CtGeneralTercero b"
				+ "WHERE b.codCompania = a.codCompania AND b.tipDocum = a.tipDocum AND b.codDocum = a.codDocum"
				+ "AND b.codActTercero = a.codActTercero)",CtGeneralTercero.class)
				.setParameter(1, p_cod_compania)
				.setParameter(2, p_cod_usr)
				.getResultList()
				;
	}
	@Override
	public List<CtGeneralTercero> devuelvePersonasPorCia(int p_cod_compania) throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM CtGeneralTercero a "
				+ "WHERE a.codCompania = ?1 "
				+ "AND a.fecValidez = (SELECT MAX(b.fecValidez) FROM CtGeneralTercero b"
				+ "WHERE b.codCompania = a.codCompania AND b.tipDocum = a.tipDocum AND b.codDocum = a.codDocum"
				+ "AND b.codActTercero = a.codActTercero)",CtGeneralTercero.class)
				.setParameter(1, p_cod_compania)
				.getResultList()
				;
	}
	@Override
	public CtGeneralTercero devuelvePersonaPorDocum(int p_cod_compania, String p_tip_docum, String p_cod_docum) throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM CtGeneralTercero a "
				+ "WHERE a.codCompania = ?1 and a.tipDocum = ?2 "
				+ "AND a.codDocum = ?3 AND a.codActTercero = 1 "
				+ "AND fecValidez = (SELECT MAX(b.fecValidez) FROM CtGeneralTercero b "
				+ "WHERE b.codCompania = a.codCompania AND b.tipDocum = a.tipDocum AND b.codDocum = a.codDocum "
				+ "AND b.codActTercero = a.codActTercero)",CtGeneralTercero.class)
				.setParameter(1, p_cod_compania)
				.setParameter(2, p_tip_docum)
				.setParameter(3, p_cod_docum)
				.getSingleResult();
	}
}