package com.landian.sql.jpa.criterion;


import org.apache.commons.lang.StringUtils;

import java.util.Date;

/**
 * 日期查询
 */
public class CriterionDateLe implements Criterion {

	private static final long serialVersionUID = 1L;

	public CriterionDateLe(String column, String date) {
		this.column = column;
		this.date = date;
	}

	public CriterionDateLe(String column, Date date) {
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
			sb.append(column +" <= '" + date.trim() + " 23:59:59'");
		}
		return sb.toString();
	}
}
