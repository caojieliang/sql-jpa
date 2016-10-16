package com.landian.sql.jpa.context;


/**
 * 由于经常需要根据ID(某属性作为key)，统计某属性总计(某属性总计作为Value)
 */
public class ResultMapConfig {

	public static ResultMapConfig newInstance(String keyField, String valueField){
		return new ResultMapConfig(keyField,valueField);
	}

	private ResultMapConfig(String keyField, String valueField){
		this.keyField = keyField;
		this.valueField = valueField;
	}

	/**
	 * 作为key的属性
	 */
	private String keyField;
	/**
	 * 作为value的属性
	 */
	private String valueField;

	public String getKeyField() {
		return keyField;
	}

	public String getValueField() {
		return valueField;
	}
}
