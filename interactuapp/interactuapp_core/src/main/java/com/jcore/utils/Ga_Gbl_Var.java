package com.jcore.utils;

import java.sql.Date;

public class Ga_Gbl_Var {
	
	public static Date getFecActual()
	{
		java.util.Date date = new java.util.Date();
		java.sql.Date  sqlDate;
		sqlDate = new java.sql.Date(date.getYear(),date.getMonth(),date.getDay());
		return sqlDate;
	}
}
