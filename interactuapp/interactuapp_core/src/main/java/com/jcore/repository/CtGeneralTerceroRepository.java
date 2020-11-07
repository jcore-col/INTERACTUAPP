package com.jcore.repository;

import java.util.List;

import com.jcore.model.entity.CtGeneralTercero;
import com.jcore.model.entity.CtGeneralTerceroPK;

public interface CtGeneralTerceroRepository extends JpaRepository<CtGeneralTercero>{
	public CtGeneralTercero buscaPorLLaveTabla(CtGeneralTerceroPK p_id) throws Exception;
	public List<CtGeneralTercero> buscaPorCompania(int p_cod_compania) throws Exception;
}
