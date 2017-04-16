package com.landian.sql.jpa.utils;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.util.List;


/**
 * 了解到有开源的工具实现就用开源的
 * @author Administrator
 */
public class SQLUtils {

	public static String intListToSQL(List<Integer> paramsList){
		String inSQL = "";
		if(!CollectionUtils.isEmpty(paramsList)){
			StringBuffer sb = new StringBuffer();
			for(Integer param : paramsList){
				if(null != param){
					sb.append(param.toString() + ",");
				}
			}
			inSQL = sb.substring(0, sb.length()-1);
		}
		return inSQL;
	}
	
	public static String longListToSQL(List<Long> paramsList) {
		String inSQL = "";
		if(!CollectionUtils.isEmpty(paramsList)){
			StringBuffer sb = new StringBuffer();
			for(Long param : paramsList){
				if(null != param){
					sb.append(param.toString() + ",");
				}
			}
			inSQL = sb.substring(0, sb.length()-1);
		}
		return inSQL;
	}
	
	public static String stringListToSQL(List<String> paramsList){
		String inSQL = "";
		if(!CollectionUtils.isEmpty(paramsList)){
			StringBuffer sb = new StringBuffer();
			for(String param : paramsList){
				if(!StringUtils.isEmpty(param)){
					sb.append("'" + param.toString() + "',");
				}
			}
			inSQL = sb.substring(0, sb.length()-1);
		}
		return inSQL;
	}
	
	
	public static String intArrayToSQL(Integer[] paramsArr){
		String inSQL = "";
		if(null != paramsArr){
			StringBuffer sb = new StringBuffer();
			for(Integer param : paramsArr){
				if(null != param){
					sb.append(param.toString() + ",");
				}
			}
			inSQL = sb.substring(0, sb.length()-1);
		}
		return inSQL;
	}
	
	public static String longArrayToSQL(Long[] paramsArr) {
		String inSQL = "";
		if(null != paramsArr){
			StringBuffer sb = new StringBuffer();
			for(Long param : paramsArr){
				if(null != param){
					sb.append(param.toString() + ",");
				}
			}
			inSQL = sb.substring(0, sb.length()-1);
		}
		return inSQL;
	}
	
	public static String stringArrayToSQL(String[] paramsArr){
		String inSQL = "";
		if(null != paramsArr){
			StringBuffer sb = new StringBuffer();
			for(String param : paramsArr){
				if(!StringUtils.isNotBlank(param)){
					sb.append("'" + param.trim() + "',");
				}
			}
			inSQL = sb.substring(0, sb.length()-1);
		}
		return inSQL;
	}

	public static String asAnyWhere(String key){
		return "%" + key.trim() + "%";
	}
}
