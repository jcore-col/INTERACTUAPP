package com.jcore.repository;

import com.jcore.model.entity.GaUsrGroupMember;
import com.jcore.model.entity.GaUsrGroupMemberPK;

public interface Ga_Int_UsrGroupMember extends JpaRepository<GaUsrGroupMember>{
	public GaUsrGroupMember buscaPorLLaveTabla(GaUsrGroupMemberPK p_id) throws Exception;
}
