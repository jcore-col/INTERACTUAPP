package com.jcore.service_interface;

import java.util.Date;
import java.util.List;

import com.jcore.model.entity.CtCampaignEntry;
import com.jcore.model.entity.CtInteractionLogEntry;

public interface CtInteractionLogEntryCrudService extends CrudService<CtInteractionLogEntry> {

	public List<CtInteractionLogEntry> historyPersonEntry(int p_cod_compania, int p_cod_campaign, String p_tip_docum,
			String p_cod_docum) throws Exception;
	
	
	public List<CtCampaignEntry> devReunionesPorFecha(int p_cod_compania
			   ,int p_cod_campaign
			   ,Date p_fec_entry) throws Exception;
	
	public List<CtInteractionLogEntry> devPersonasReunion(int p_cod_compania, int p_cod_campaign,
			int p_num_secu_entry_day, Date p_fec_entry) throws Exception;
}
