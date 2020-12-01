package com.jcore.service_interface;

import java.util.List;

import com.jcore.model.entity.GaEstado;

public interface GaEstadoCrudService extends CrudService<GaEstado>{
	
	public List<GaEstado> devEstadosPorPais(String p_cod_pais) throws Exception;
	
}
