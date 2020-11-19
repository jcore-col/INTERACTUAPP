package com.jcore.repository;

import java.util.List;

import com.jcore.model.entity.GaAccessControl;

public interface GaAccessControlRepository extends JpaRepository<GaAccessControl>{
	List<GaAccessControl> buscaPorUsr(String p_cod_usr) throws Exception;
}
