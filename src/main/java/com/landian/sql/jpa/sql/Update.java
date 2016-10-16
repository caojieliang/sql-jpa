package com.landian.sql.jpa.sql;


import com.landian.sql.jpa.context.JavaType;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 更新单元建造厂(限制建造器)
 * to be continute
 */
public class Update {
	
	/**
	 * 等于 
	 */
	public static UpdateUnit set(String column, String value){
		return new UpdateUnitEqual(column, value, JavaType.STRING);
	}
	/**
	 * 等于 
	 */
	public static UpdateUnit set(String column, int value){
		return new UpdateUnitEqual(column, value, JavaType.INT);
	}
	/**
	 * 等于 
	 */
	public static UpdateUnit set(String column, long value){
		return new UpdateUnitEqual(column, value, JavaType.LONG);
	}
	/**
	 * 等于 
	 */
	public static UpdateUnit set(String column, Date value){
		return new UpdateUnitEqual(column, value, JavaType.DATE);
	}
	/**
	 * 等于
	 */
	public static UpdateUnit set(String column, float value){
		return new UpdateUnitEqual(column, value, JavaType.FLOAT);
	}
	/**
	 * 等于
	 */
	public static UpdateUnit set(String column, double value){
		return new UpdateUnitEqual(column, value, JavaType.DOUBLE);
	}
	/**
	 * 等于
	 */
	public static UpdateUnit set(String column, BigDecimal value){
		return new UpdateUnitEqual(column, value, JavaType.BIGDECIMAL);
	}
	/**
	 * 为空
	 */
	public static UpdateUnit setNull(String column){
		return new UpdateUnitNull(column);
	}

	/**
	 * 自定义
	 */
	public static UpdateUnit sql(String sql){
		return new UpdateUnitSQL(sql);
	}
	
}
