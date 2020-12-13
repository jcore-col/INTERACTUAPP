package com.jcore.repository;

import java.sql.Date;
import java.util.List;

import com.jcore.model.entity.CtCampaignEntry;

public interface CtCampaignEntryRepository extends JpaRepository<CtCampaignEntry>{

	public List<CtCampaignEntry> buscaPorFec_entry(int p_cod_compania
												  ,int p_cod_campaign
												  ,Date p_fec_entry) throws Exception;
	
	public int next_secu_entry_day(int p_cod_compania
								  ,int p_cod_campaign) throws Exception;
	
	public List<CtCampaignEntry> devCampaignsEntry(int p_cod_compania, int p_cod_campaign) throws Exception;
}
