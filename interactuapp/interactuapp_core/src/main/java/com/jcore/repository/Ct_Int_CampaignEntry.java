package com.jcore.repository;

import java.sql.Date;
import java.util.List;

import com.jcore.model.entity.CtCampaignEntry;
import com.jcore.model.entity.CtCampaignEntryPK;

public interface Ct_Int_CampaignEntry extends JpaRepository<CtCampaignEntry>{
	
	public CtCampaignEntry buscaPorLLaveTabla(CtCampaignEntryPK p_id) throws Exception;
	
	public List<CtCampaignEntry> buscaPorFec_entry(int p_cod_compania
												  ,int p_cod_campaign
												  ,Date p_fec_entry) throws Exception;
	
	public int return_next_secu_entry_day(int p_cod_compania
										 ,int p_cod_campaign
										 ,Date p_fec_entry) throws Exception;
}
