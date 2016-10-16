package com.landian.sql.jpa.criterion;

/**
 * 查询的属性
 */
public class Field {

	public static Field newInstance(String field){
		return new Field(field);
	}

	private Field() {
	}

	private Field(String field) {
		this.field = field;
	}

	/**
	 *  
	 */
	public String field;

	public String getField() {
		return field;
	}
}
