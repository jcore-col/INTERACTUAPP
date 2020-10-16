package com.jcore.repository;

import com.jcore.model.entity.GaAccessControl;
import com.jcore.model.entity.GaAccessControlPK;

public interface Ga_Int_AccessControl extends JpaRepository<GaAccessControl>{
	public GaAccessControl buscaPorLLaveTabla(GaAccessControlPK p_id) throws Exception;
}
