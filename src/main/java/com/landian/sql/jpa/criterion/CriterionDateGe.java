package com.landian.sql.jpa.criterion;


import org.apache.commons.lang.StringUtils;

import java.util.Date;

/**
 * 日期查询
 */
public class CriterionDateGe implements Criterion {

	private static final long serialVersionUID = 1L;

	public CriterionDateGe(String column, String date) {
		this.column = column;
		this.date = date;
	}

	public CriterionDateGe(String column, Date date) {
		this.column = column;
		this.date = CriterionUtils.DATE_FORMAT.format(date);
	}

	/**
	 * 字段
	 */
	private String column;
	/**
	 * 日期时间
	 */
	private String date;

	/**
	 * SQL片段
	 */
	public String SQL(){
		StringBuffer sb = new StringBuffer();
		if(StringUtils.isNotBlank(date)){
			sb.append(column + " >= '" + date.trim() + "'");
		}
		return sb.toString();
	}
}
