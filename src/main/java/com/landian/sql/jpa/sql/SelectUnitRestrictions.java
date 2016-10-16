package com.landian.sql.jpa.sql;



/**
 * 选择单元建造厂(限制建造器)
 * to be continute
 */
public class SelectUnitRestrictions{
	/**
	 * 自定义
	 */
	public static SelectUnit sql(String sql){
		return new SelectUnitSQL(sql);
	}
	/**
	 * 字段
	 */
	public static SelectUnit column(String column){
		return new SelectUnitColumn(column);
	}
	
}
