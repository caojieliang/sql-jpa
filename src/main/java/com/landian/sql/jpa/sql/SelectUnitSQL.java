package com.landian.sql.jpa.sql;

/**
 * 自定义选择SQL
 * date 15/08/26
 */
public class SelectUnitSQL implements SelectUnit {
	
	private static final long serialVersionUID = 1L;

	public SelectUnitSQL(String sql) {
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
