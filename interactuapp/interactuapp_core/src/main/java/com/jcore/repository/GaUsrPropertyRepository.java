package com.jcore.repository;

import com.jcore.model.entity.GaUsrProperty;

public interface GaUsrPropertyRepository extends JpaRepository<GaUsrProperty>{
	GaUsrProperty buscaPorUsr(String p_cod_usr) throws Exception;
}
