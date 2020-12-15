package com.jcore.service;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.jcore.model.entity.CtCampaignEntry;
import com.jcore.model.entity.CtInteractionLogEntry;
import com.jcore.repository.CtInteractionLogEntryRepository;
import com.jcore.service_interface.CtInteractionLogEntryCrudService;

//Clase de mantenimiento para entity usa las clase de tipo EntityManager
@Named
public class CtInteractionLogEntryService implements CtInteractionLogEntryCrudService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject 
	private CtInteractionLogEntryRepository ctInteractionLogEntryRepository;
	
	@Transactional
	@Override
	public void insert(CtInteractionLogEntry t) throws Exception {
		// TODO Auto-generated method stub
		this.ctInteractionLogEntryRepository.insert(t);
	}

	@Transactional
	@Override
	public void update(CtInteractionLogEntry t) throws Exception {
		// TODO Auto-generated method stub
		this.ctInteractionLogEntryRepository.update(t);
	}

	@Transactional
	@Override
	public void delete(CtInteractionLogEntry t) throws Exception {
		// TODO Auto-generated method stub
		this.ctInteractionLogEntryRepository.delete(t);
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
		return this.ctInteractionLogEntryRepository.devReunionesPorFecha(p_cod_compania, p_cod_campaign, p_fec_entry);
	}

	@Override
	public List<CtInteractionLogEntry> devPersonasReunion(int p_cod_compania, int p_cod_campaign,
			int p_num_secu_entry_day, Date p_fec_entry) throws Exception {
		// TODO Auto-generated method stub
		return this.ctInteractionLogEntryRepository.devPersonasReunion(p_cod_compania, p_cod_campaign, p_num_secu_entry_day, p_fec_entry);
	}

	
}
