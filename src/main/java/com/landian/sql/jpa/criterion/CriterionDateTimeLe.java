package com.landian.sql.jpa.criterion;


import org.apache.commons.lang.StringUtils;

import java.util.Date;

/**
 * 日期查询
 */
public class CriterionDateTimeLe implements Criterion {

	private static final long serialVersionUID = 1L;

	public CriterionDateTimeLe(String column, Date date) {
		this.column = column;
		this.dateTime = CriterionUtils.TIME_FORMAT.format(date);
	}

	/**
	 * 字段
	 */
	private String column;
	/**
	 * 日期时间
	 */
	private String dateTime;

	/**
	 * SQL片段 
	 */
	public String SQL(){
		StringBuffer sb = new StringBuffer();
		if(StringUtils.isNotBlank(dateTime)){
			sb.append(column + " <= '" + dateTime.trim() + "'");
		}
		return sb.toString();
	}
}
