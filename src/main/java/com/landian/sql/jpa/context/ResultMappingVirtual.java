package com.landian.sql.jpa.context;

/* 虚拟ResultMapping
 * 因 org.apache.ibatis.mapping.ResultMapping 没有public构造方法 
 * 在设计通用Proxy时暂时这么干
 */
public class ResultMappingVirtual {
	
	public static ResultMappingVirtual getInstance(String property, String column){
		return new ResultMappingVirtual(property, column);
	}
	public String column;
	public String property;
	
	public ResultMappingVirtual(String property, String column) {
		this.property = property;
		this.column = column;
	}

	public String getColumn() {
		return column;
	}

	public String getProperty() {
		return property;
	}
}
