package com.jcore.repository;

import java.util.List;

import com.jcore.model.entity.CtGeneralTercero;

public interface CtGeneralTerceroRepository extends JpaRepository<CtGeneralTercero>{
	public List<CtGeneralTercero> devuelvePersonasPorUsr(int p_cod_compania,String p_cod_usr) throws Exception;
}
