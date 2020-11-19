package com.jcore.service_interface;

import java.util.List;

import com.jcore.model.entity.GaAccessControl;

public interface GaAccessControlCrudService extends CrudService<GaAccessControl>{
	public List<GaAccessControl> buscaPorUsr(String p_cod_usr) throws Exception;

}
