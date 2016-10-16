package com.landian.sql.jpa.sql;

/**
 * 字段选择SQL
 * date 15/09/10
 */
public class SelectUnitColumn implements SelectUnit{
	
	private static final long serialVersionUID = 1L;

	public SelectUnitColumn(String column) {
		this.column = column;
	}
	
	/**
	 * 条件SQL片段
	 */
	private String column;

	/**
	 * SQL片段 
	 */
	public String SQL(){
		return column;
	}
}
