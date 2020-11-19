package com.jcore.repository;

import com.jcore.model.entity.GaUsrGroupMember;

public interface GaUsrGroupMemberRepository extends JpaRepository<GaUsrGroupMember>{
	
	GaUsrGroupMember buscaPorUsr(String p_cod_usr) throws Exception;
	GaUsrGroupMember buscaPorDoc(String p_cod_usr) throws Exception;
}
