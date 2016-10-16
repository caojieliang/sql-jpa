package com.landian.sql.jpa.sql;

/**
 * 等于条件SQL片段
 */
public class UpdateUnitNull implements UpdateUnit {

	private static final long serialVersionUID = 1L;

	public UpdateUnitNull(String column) {
		this.column = column;
	}
	
	/**
	 * 字段
	 */
	private String column;

	/**
	 * SQL片段 
	 */
	public String SQL(){
		return column + " = null ";
	}
}
