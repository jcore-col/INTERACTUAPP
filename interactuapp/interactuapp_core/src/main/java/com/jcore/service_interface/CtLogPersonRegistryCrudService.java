package com.jcore.service_interface;

import java.util.List;

import com.jcore.model.entity.CtGeneralTercero;
import com.jcore.model.entity.CtLogPersonRegistry;

public interface CtLogPersonRegistryCrudService extends CrudService<CtLogPersonRegistry>{

	public CtLogPersonRegistry buscarPorCodDocum (int p_cod_compania, int p_cod_campaign, String p_tip_docum,String p_cod_docum) throws Exception;
	public CtLogPersonRegistry buscarPersonaPorUsr(int p_cod_compania, int p_cod_campaign, String p_tip_docum,
			String p_cod_docum,String p_cod_usr) throws Exception;
}
