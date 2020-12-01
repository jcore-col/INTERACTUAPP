package com.jcore.repository;

import java.util.List;

import com.jcore.model.entity.GaEstado;

public interface GaEstadoRepository extends JpaRepository<GaEstado>{
	
	public List<GaEstado> devEstadosPorPais(String p_cod_pais) throws Exception;
}
