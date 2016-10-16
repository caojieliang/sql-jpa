package com.landian.sql.jpa.utils;

import com.landian.sql.builder.SQL;


/**
 * mybatis里的SQL类没发现
 * limit，count等字眼
 * 这里代理扩展处理一下SQL
 */
public class SQLProxy {
	public static String toPageSQL(SQL sqlBuilder,int start,int size){
		StringBuffer sql = new StringBuffer(sqlBuilder.toString());
        sql.append(" limit ");
        sql.append("" + start + ",");
        sql.append("" + size);
        return sql.toString();
	}
}
