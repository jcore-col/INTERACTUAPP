package com.jcore.service_interface;

import com.jcore.model.entity.GaUsrGroupMember;

public interface GaUsrGroupMemberCrudService extends CrudService<GaUsrGroupMember>{
	
	GaUsrGroupMember buscaPorUsr(String p_cod_usr) throws Exception;
	GaUsrGroupMember buscaPorDoc(String p_cod_usr) throws Exception;

}
