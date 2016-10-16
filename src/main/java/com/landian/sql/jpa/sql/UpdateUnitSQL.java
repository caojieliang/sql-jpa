package com.landian.sql.jpa.sql;

/**
 * 自定义SQL条件
 */
public class UpdateUnitSQL implements UpdateUnit{
	
	private static final long serialVersionUID = 1L;

	public UpdateUnitSQL(String sql) {
		this.sql = sql;
	}
	
	/**
	 * 条件SQL片段
	 */
	private String sql;

	/**
	 * SQL片段 
	 */
	public String SQL(){
		return sql;
	}
}
