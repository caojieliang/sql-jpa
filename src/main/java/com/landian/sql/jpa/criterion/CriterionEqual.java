package com.landian.sql.jpa.criterion;


import com.landian.sql.jpa.context.JavaType;

/**
 * 相等条件SQL片段
 */
public class CriterionEqual implements Criterion {
	
	private static final long serialVersionUID = 1L;

	public CriterionEqual(String column, Object value, JavaType type) {
		this.column = column;
		this.value = value;
		this.type = type;
	}
	
	/**
	 * 字段
	 */
	private String column;
	/**
	 * 值
	 */
	private Object value;
	/**
	 * 值类型
	 */
	private JavaType type;

	/**
	 * SQL片段 
	 */
	public String SQL(){
		if(type == JavaType.INT || type == JavaType.LONG){
			return column + " = " + value;
		}else if(type == JavaType.STRING){
			return column + " = '" + value + "'";
		}
		return "";
	}
}
