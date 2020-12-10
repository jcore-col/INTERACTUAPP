package com.jcore.repository;

import com.jcore.model.entity.CtLogPersonRegistry;

public interface CtLogPersonRegistryRepository extends JpaRepository<CtLogPersonRegistry>{
	
	public CtLogPersonRegistry buscarPorCodDocum (int p_cod_compania, int p_cod_campaign, String p_tip_docum,String p_cod_docum) throws Exception;
	public CtLogPersonRegistry buscarPersonaPorUsr(int p_cod_compania, int p_cod_campaign, String p_tip_docum,
			String p_cod_docum,String p_cod_usr) throws Exception;
	
}
