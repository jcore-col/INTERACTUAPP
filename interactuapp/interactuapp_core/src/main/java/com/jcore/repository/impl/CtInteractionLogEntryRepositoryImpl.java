package com.jcore.repository.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jcore.constantes_sistema.Ga;
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
	
	
	
}
