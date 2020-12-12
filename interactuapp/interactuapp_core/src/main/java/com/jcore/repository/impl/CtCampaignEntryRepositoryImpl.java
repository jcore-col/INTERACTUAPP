package com.jcore.repository.impl;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jcore.constantes_sistema.Ga;
import com.jcore.model.entity.CtCampaignEntry;
import com.jcore.repository.CtCampaignEntryRepository;

public class CtCampaignEntryRepositoryImpl implements CtCampaignEntryRepository,Serializable{
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext( unitName = Ga.UNIDAD_PERSISTENCE_JPA)
	private EntityManager em;
	@Override
	public void insert(CtCampaignEntry t) throws Exception {
		// TODO Auto-generated method stub
		em.persist(t);
	}
	@Override
	public void update(CtCampaignEntry t) throws Exception {
		// TODO Auto-generated method stub
		em.merge(t);
	}
	@Override
	public void delete(CtCampaignEntry t) throws Exception {
		// TODO Auto-generated method stub
		em.remove(em.merge(t));
	}
	@Override
	public CtCampaignEntry findById(CtCampaignEntry t) throws Exception {
		// TODO Auto-generated method stub
		
		return em.find(t.getClass(), t.getId());
	}
	@Override
	public List<CtCampaignEntry> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<CtCampaignEntry> buscaPorFec_entry(int p_cod_compania, int p_cod_campaign, Date p_fec_entry)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int next_secu_entry_day(int p_cod_compania, int p_cod_campaign, Date p_fec_entry) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<CtCampaignEntry> devCampaignsEntry(int p_cod_compania, int p_cod_campaign) throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT * FROM CtCampaignEntry a "
				+ "WHERE a.id.codCompania = ?1 "
				+ "AND a.id.codCampaign	  = ?2 "
				+ "ORDER BY a.id.fecEntry desc",CtCampaignEntry.class)
				.setParameter(1, p_cod_compania)
				.setParameter(2, p_cod_campaign).getResultList();
	}
	
	
	
}
