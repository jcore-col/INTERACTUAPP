package com.jcore.repository;

import java.util.List;

import com.jcore.model.entity.CtGeneralTercero;

public interface CtGeneralTerceroRepository extends JpaRepository<CtGeneralTercero>{
	public List<CtGeneralTercero> devuelvePersonasPorUsr(int p_cod_compania,String p_cod_usr) throws Exception;
	public List<CtGeneralTercero> devuelvePersonasPorCia(int p_cod_compania) throws Exception;
	public CtGeneralTercero devuelvePersonaPorDocum(int p_cod_compania,String p_tip_docum, String p_cod_docum) throws Exception;
}
