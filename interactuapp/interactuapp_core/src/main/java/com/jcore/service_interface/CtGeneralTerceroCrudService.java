package com.jcore.service_interface;

import java.util.List;

import com.jcore.model.entity.CtGeneralTercero;

public interface CtGeneralTerceroCrudService extends CrudService<CtGeneralTercero>{
	
	public List<CtGeneralTercero> devuelvePersonasPorUsr(int p_cod_compania,int p_cod_campaign,String p_cod_usr) throws Exception;
	public List<CtGeneralTercero> devuelvePersonasPorCia(int p_cod_compania, int  cod_campaign) throws Exception;
	public CtGeneralTercero devuelvePersonaPorDocum(int p_cod_compania,String p_tip_docum, String p_cod_docum) throws Exception;
	
}
