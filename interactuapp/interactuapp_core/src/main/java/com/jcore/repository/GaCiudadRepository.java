package com.jcore.repository;

import java.util.List;

import com.jcore.model.entity.GaCiudad;

public interface GaCiudadRepository extends JpaRepository<GaCiudad>{
	
	public List<GaCiudad> devCiudadPorPaisYEstado(String p_cod_pais, String p_cod_estado) throws Exception;
}
