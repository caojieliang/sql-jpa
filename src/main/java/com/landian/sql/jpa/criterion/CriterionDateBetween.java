package com.landian.sql.jpa.criterion;


import com.landian.sql.jpa.annotation.DateRangeTypePolicy;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * 日期查询
 */
public class CriterionDateBetween implements Criterion {
	
	private static final long serialVersionUID = 1L;

	public CriterionDateBetween(String column, String beginTime, String endTime,DateRangeTypePolicy type) {
		this.column = column;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.type = type;
	}
	/**
	 * 字段
	 */
	private String column;
	/**
	 * 时间类型
	 */
	private DateRangeTypePolicy type;
	/**
	 * 开始时间
	 */
	private String beginTime;
	/**
	 * 结束时间
	 */
	private String endTime;

	/**
	 * SQL片段 
	 */
	public String SQL(){
		List<String> sqlList = new ArrayList<String>();
		StringBuffer sb = new StringBuffer();
		if(StringUtils.isNotBlank(beginTime) || StringUtils.isNotBlank(endTime)){
			if(DateRangeTypePolicy.DATE == type){
				if(StringUtils.isNotBlank(beginTime)){
					sqlList.add(column + " >= '" + beginTime + "'");
				}
				if(StringUtils.isNotBlank(endTime)){
					sqlList.add(column +" <= '" + endTime + " 23:59:59'");
				}
			}
			if(sqlList.size()>1){
				sb.append("(");
				sb.append("(" + sqlList.get(0) + ")");
				sb.append(" and (" + sqlList.get(1) + ")");
				sb.append(")");
			}else{
				sb.append("(" + sqlList.get(0) + ")");
			}
		}
		return sb.toString();
	}
}
