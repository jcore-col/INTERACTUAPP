package com.jcore.repository;

import java.util.List;

import com.jcore.model.entity.GaLocalidad;

public interface GaLocalidadRepository extends JpaRepository<GaLocalidad>{
	public List<GaLocalidad> devLocalidadesPorCiudad (String cod_pais, String cod_ciudad) throws Exception;
}
