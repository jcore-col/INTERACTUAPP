package com.jcore.repository.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jcore.constantes_sistema.Ga;
import com.jcore.model.entity.CtCampaignEntry;
import com.jcore.model.entity.CtInteractionLogEntry;
import com.jcore.repository.CtInteractionLogEntryRepository;

public class CtInteractionLogEntryRepositoryImpl implements CtInteractionLogEntryRepository,Serializable{
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext( unitName = Ga.UNIDAD_PERSISTENCE_JPA)
	private EntityManager em;
	@Override
	public void insert(CtInteractionLogEntry t) throws Exception {
		// TODO Auto-generated method stub
		em.persist(t);
	}
	@Override
	public void update(CtInteractionLogEntry t) throws Exception {
		// TODO Auto-generated method stub
		em.merge(t);
	}
	@Override
	public void delete(CtInteractionLogEntry t) throws Exception {
		// TODO Auto-generated method stub
		em.remove(em.merge(t));
	}
	@Override
	public CtInteractionLogEntry findById(CtInteractionLogEntry t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<CtInteractionLogEntry> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<CtInteractionLogEntry> historyPersonEntry(int p_cod_compania, int p_cod_campaign, String p_tip_docum,
			String p_cod_docum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<CtCampaignEntry> devReunionesPorFecha(int p_cod_compania, int p_cod_campaign, Date p_fec_entry)
			throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM CtCampaignEntry a "
				+ "WHERE a.id.codCompania = ?1 "
				+ "AND a.id.codCampaign = ?2 "
				+ "AND a.fecEntry = ?3 "
				+ "AND a.tipSituacion = '2' "
				+ "ORDER BY a.id.numSecuEntryDay ASC", CtCampaignEntry.class)
				.setParameter(1, p_cod_compania)
				.setParameter(2, p_cod_campaign)
				.setParameter(3, p_fec_entry).getResultList();
	}
	@Override
	public List<CtInteractionLogEntry> devPersonasReunion(int p_cod_compania, int p_cod_campaign,
			int p_num_secu_entry_day, Date p_fec_entry) throws Exception {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT a FROM CtInteractionLogEntry a "
				+ "WHERE a.id.codCompania = ?1 "
				+ "AND a.id.codCampaign = ?2 "
				+ "AND a.id.numSecuEntryDay = ?3 "
				+ "AND a.fecEntry = ?4", CtInteractionLogEntry.class)
				.setParameter(1, p_cod_compania)
				.setParameter(2, p_cod_campaign)
				.setParameter(3, p_num_secu_entry_day)
				.setParameter(4, p_fec_entry).getResultList();
	}
	
	
	
}
