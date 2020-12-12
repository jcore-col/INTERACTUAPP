package com.jcore.service;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.jcore.model.entity.CtCampaignEntry;
import com.jcore.repository.CtCampaignEntryRepository;
import com.jcore.service_interface.CtCampaignEntryCrudService;

//Clase de mantenimiento para entity usa las clase de tipo EntityManager
@Named
public class CtCampaignEntryService implements CtCampaignEntryCrudService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject 
	private CtCampaignEntryRepository ctCampaignEntryRepository;

	@Transactional
	@Override
	public void insert(CtCampaignEntry t) throws Exception {
		// TODO Auto-generated method stub
		this.ctCampaignEntryRepository.insert(t);
	}

	@Transactional
	@Override
	public void update(CtCampaignEntry t) throws Exception {
		// TODO Auto-generated method stub
		this.ctCampaignEntryRepository.update(t);
	}

	@Transactional
	@Override
	public void delete(CtCampaignEntry t) throws Exception {
		// TODO Auto-generated method stub
		this.ctCampaignEntryRepository.delete(t);
	}

	@Override
	public CtCampaignEntry findById(CtCampaignEntry t) throws Exception {
		// TODO Auto-generated method stub
		return null;
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
		return ctCampaignEntryRepository.devCampaignsEntry(p_cod_compania, p_cod_campaign);
	}

	
	
	
	
}
