package com.landian.sql.jpa.sql;

import com.landian.sql.jpa.annotation.Transient;

import java.lang.reflect.Field;
import java.text.MessageFormat;

/**
 * 选择单元追加器Builder
 * date 16/07/13
 * to be continue
 * 感觉来了，要将一些东西搬过来了
 */
public class SelectUnitAppenderBuilder {

	/**
	 * 根据Pojo class，构建常用sum统计选择单元
	 * @return
	 */
	public static SelectUnitAppender buildSumByPojo(Class clazz){
		SelectUnitAppender selectUnitAppender = SelectUnitAppender.newInstance();
		Field[] fields = clazz.getDeclaredFields();
		if(null != fields && fields.length > 0){
			for(Field field : fields){
				//可以访问private
				field.setAccessible(true);
				String fieldName = field.getName();
				//0.忽略透明注解属性
				Transient transientAnnotations = field.getAnnotation(Transient.class);
				if(null != transientAnnotations){
					continue;
				}
				String sqlSrc = "IFNULL(SUM({0}),0) as {1}";
				String sql = MessageFormat.format(sqlSrc,fieldName,fieldName);
				selectUnitAppender.sql(sql);
			}
		}
		return selectUnitAppender;
	}
}
