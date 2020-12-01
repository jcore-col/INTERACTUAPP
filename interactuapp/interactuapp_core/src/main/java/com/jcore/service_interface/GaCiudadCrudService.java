package com.jcore.service_interface;

import java.util.List;

import com.jcore.model.entity.GaCiudad;

public interface GaCiudadCrudService extends CrudService<GaCiudad>{
	
	public List<GaCiudad> devCiudadPorPaisYEstado(String p_cod_pais, String p_cod_estado) throws Exception;
	
}
