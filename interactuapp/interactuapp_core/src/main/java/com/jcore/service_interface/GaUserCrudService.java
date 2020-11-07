package com.jcore.service_interface;

import com.jcore.model.entity.GaUser;

public interface GaUserCrudService extends CrudService<GaUser>{
	
	GaUser buscaPorUsr(String p_cod_usr) throws Exception;
	
}
