package com.landian.sql.jpa.criterion;

/**
 * 自定义SQL条件
 */
public class CriterionSQL implements Criterion {
	
	private static final long serialVersionUID = 1L;

	public CriterionSQL(String sql) {
		this.sql = sql;
	}
	
	/**
	 * 条件SQL片段
	 */
	private String sql;

	/**
	 * SQL片段 
	 */
	@SuppressWarnings("unchecked")
	public String SQL(){
		return sql;
	}
}
