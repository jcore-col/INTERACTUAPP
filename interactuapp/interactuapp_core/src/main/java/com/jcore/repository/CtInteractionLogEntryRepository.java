package com.jcore.repository;

import java.sql.Date;
import java.util.List;

import com.jcore.model.entity.CtCampaignEntry;
import com.jcore.model.entity.CtInteractionLogEntry;

public interface CtInteractionLogEntryRepository extends JpaRepository<CtInteractionLogEntry>{
	
	public List<CtInteractionLogEntry> historyPersonEntry(int p_cod_compania
														 ,int p_cod_campaign
														 ,String p_tip_docum
														 ,String p_cod_docum) throws Exception;
	
	public List<CtCampaignEntry> devReunionesPorFecha(int p_cod_compania
												     ,int p_cod_campaign
												     ,Date p_fec_entry) throws Exception;
	
	public List<CtInteractionLogEntry> devPersonasReunion  (int p_cod_compania
			   											   ,int p_cod_campaign
			   											   ,int p_num_secu_entry_day
			   											   ,Date p_fec_entry) throws Exception;
}
