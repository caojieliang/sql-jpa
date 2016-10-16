package com.landian.sql.jpa.criterion;


/**
 * 大于等于
 */
public class CriterionLe implements Criterion {

	private static final long serialVersionUID = 1L;

	public CriterionLe(String column, int value) {
		this.column = column;
		this.value = value;
	}
	
	/**
	 * 字段
	 */
	private String column;
	/**
	 * 值
	 */
	private int value;

	/**
	 * SQL片段 
	 */
	public String SQL(){
		return column + " <= " + value;
	}
}
