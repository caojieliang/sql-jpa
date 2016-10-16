package com.landian.sql.jpa.criterion;

import com.landian.sql.jpa.context.JavaType;
import com.landian.sql.jpa.utils.SQLUtils;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collection;
import java.util.List;



/**
 * IN条件SQL片段
 */
public class CriterionIn implements Criterion {
	
	private static final long serialVersionUID = 1L;

	public CriterionIn(String column, Collection values, JavaType type) {
		this.column = column;
		this.values = values;
		this.type = type;
	}
	
	public CriterionIn(String column, Object[] valueArr, JavaType type) {
		this.column = column;
		this.valueArr = valueArr;
		this.type = type;
	}
	
	/**
	 * 字段
	 */
	private String column;
	/**
	 * 值
	 */
	private Collection values;
	/**
	 * 值
	 */
	private Object[] valueArr;
	/**
	 * 类型
	 */
	private JavaType type;

	/**
	 * SQL片段
	 * modify date 15/08/24
	 */
	@SuppressWarnings("unchecked")
	public String SQL(){
		if(CollectionUtils.isNotEmpty(values)){
			if(type == JavaType.INT){
				List<Integer> paramsList = (List<Integer>) values;
				return column + " in (" + SQLUtils.intListToSQL(paramsList) + ")";
			}else if(type == JavaType.LONG){
				List<Long> paramsList = (List<Long>) values;
				return column + " in (" + SQLUtils.longListToSQL(paramsList) + ")";
			}else if(type == JavaType.STRING){
				List<String> paramsList = (List<String>) values;
				return column + " in (" + SQLUtils.stringListToSQL(paramsList) + ")";
			}
		}else if(null != valueArr && valueArr.length > 0){
			if(type == JavaType.INT){
				Integer[] paramsArr = (Integer[]) valueArr;
				return column + " in (" + SQLUtils.intArrayToSQL(paramsArr) + ")";
			}else if(type == JavaType.LONG){
				Long[] paramsArr = (Long[]) valueArr;
				return column + " in (" + SQLUtils.longArrayToSQL(paramsArr) + ")";
			}else if(type == JavaType.STRING){
				String[] paramsArr = (String[]) valueArr;
				return column + " in (" + SQLUtils.stringArrayToSQL(paramsArr) + ")";
			}
		}
		return "";
	}
}
