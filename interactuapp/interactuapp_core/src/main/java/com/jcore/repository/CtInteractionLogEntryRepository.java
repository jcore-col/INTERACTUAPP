package com.jcore.repository;

import java.util.List;

import com.jcore.model.entity.CtInteractionLogEntry;

public interface CtInteractionLogEntryRepository extends JpaRepository<CtInteractionLogEntry>{
	
	public List<CtInteractionLogEntry> historyPersonEntry(int p_cod_compania
														 ,int p_cod_campaign
														 ,String p_tip_docum
														 ,String p_cod_docum) throws Exception;
	
	
}
