package com.jcore.service_interface;

import com.jcore.model.entity.GaUser;
import com.jcore.model.entity.GaUsrProperty;

public interface GaUsrPropertyCrudService extends CrudService<GaUsrProperty>{
	
	GaUser buscaPorUsr(String p_cod_usr) throws Exception;

}
