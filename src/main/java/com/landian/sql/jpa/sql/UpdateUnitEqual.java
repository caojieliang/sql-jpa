package com.landian.sql.jpa.sql;

import com.landian.sql.jpa.context.JavaType;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;


/**
 * 等于条件SQL片段
 */
public class UpdateUnitEqual implements UpdateUnit {
	
	private static final long serialVersionUID = 1L;
	
	public UpdateUnitEqual(String column, Object value, JavaType type) {
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
		if(null == value){
			throwRuntimeException("字段：" + column + "更新值不能为空!");
		}
		if(type == JavaType.INT || type == JavaType.LONG){
			return column + " = " + value;
		}else if(type == JavaType.STRING){
			return column + " = '" + value + "'";
		}else if(type == JavaType.DATE){
			SimpleDateFormat dfm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateStr = dfm.format(value);
			return column + " = '" + dateStr + "'";
		}else if(type == JavaType.FLOAT){
			Float floatVal = (Float) value;
			return column + " = " + floatVal.floatValue() + "";
		}else if(type == JavaType.DOUBLE){
			Double doubleVal = (Double) value;
			return column + " = " + doubleVal.doubleValue() + "";
		}else if(type == JavaType.BIGDECIMAL){
			BigDecimal val = (BigDecimal) value;
			return column + " = " + val.toString() + "";
		}
		return "";
	}

	private void throwRuntimeException(String message){
		throw new RuntimeException(message);
	}
}
