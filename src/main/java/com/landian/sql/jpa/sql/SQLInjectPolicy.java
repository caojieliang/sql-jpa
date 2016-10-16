package com.landian.sql.jpa.sql;

/**
 * 替换掉这些特殊字符可以防止sql注入
 */
public class SQLInjectPolicy{

	public static String transform(String srcSql){
		srcSql=srcSql.replaceAll("\\\\","\\\\\\\\");
		srcSql=srcSql.replaceAll("'","\\\\'");
		srcSql=srcSql.replaceAll("_","\\\\_");
		srcSql=srcSql.replaceAll("\"","\\\\\"");
		return srcSql;
	}
}
