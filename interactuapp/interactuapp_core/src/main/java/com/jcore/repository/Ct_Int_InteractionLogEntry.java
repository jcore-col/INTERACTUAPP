package com.jcore.repository;

import java.util.List;

import com.jcore.model.entity.CtInteractionLogEntry;
import com.jcore.model.entity.CtInteractionLogEntryPK;

public interface Ct_Int_InteractionLogEntry extends JpaRepository<CtInteractionLogEntry>{
	
	public CtInteractionLogEntry buscaPorLLaveTabla(CtInteractionLogEntryPK p_id) throws Exception;
	
	public List<CtInteractionLogEntry> buscaPorCodDocum(int p_cod_compania
													   ,int p_cod_campaign
													   ,String p_tip_docum
													   ,String p_cod_docum) throws Exception;
	
	
}
