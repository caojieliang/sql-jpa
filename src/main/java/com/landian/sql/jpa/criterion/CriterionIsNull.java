package com.landian.sql.jpa.criterion;


/**
 * 为空条件SQL片段
 */
public class CriterionIsNull implements Criterion {

	private static final long serialVersionUID = 1L;

	public CriterionIsNull(String column) {
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
		return column + " is null ";
	}
}
