package com.jcore.service_interface;

import java.util.List;

import com.jcore.model.entity.CtInteractionLogEntry;

public interface CtInteractionLogEntryCrudService extends CrudService<CtInteractionLogEntry> {

	public List<CtInteractionLogEntry> historyPersonEntry(int p_cod_compania, int p_cod_campaign, String p_tip_docum,
			String p_cod_docum) throws Exception;

}
