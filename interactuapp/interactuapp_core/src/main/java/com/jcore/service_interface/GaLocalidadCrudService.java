package com.jcore.service_interface;

import java.util.List;

import com.jcore.model.entity.GaLocalidad;

public interface GaLocalidadCrudService extends CrudService<GaLocalidad>{
	
	public List<GaLocalidad> devLocalidadesPorCiudad (String cod_pais, String cod_ciudad) throws Exception;
	
}
