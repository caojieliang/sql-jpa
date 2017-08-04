package com.landian.sql.jpa.criterion;


import com.landian.sql.jpa.sql.SQLInjectPolicy;
import org.apache.commons.lang.StringUtils;

/**
 * Like条件SQL片段
 * 基于hibernate使用经验，
 * 只设计最常用的like条件查询 MatchMode.ANYWHERE，
 * 即模糊查询
 */
public class CriterionLike implements Criterion {
	
	private static final long serialVersionUID = 1L;

	public CriterionLike(String column, String value) {
		this.column = column;
		this.value = value;
	}
	
	/**
	 * 字段
	 */
	private String column;
	/**
	 * 关键字
	 */
	private String value;

	/**
	 * SQL片段 
	 */
	public String SQL(){
		if(StringUtils.isNotBlank(value)){
			String keyInjectPolicy = SQLInjectPolicy.transform(value.trim());
			return column + " like '%" + keyInjectPolicy + "%'";
		}
		return "";
	}
}
