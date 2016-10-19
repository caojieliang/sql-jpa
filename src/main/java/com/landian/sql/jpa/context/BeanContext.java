package com.landian.sql.jpa.context;


import com.landian.sql.jpa.annotation.IdTypePolicy;

/**
 * 映射上下文提口
 * 没有将配置用注解写在Bean里，只因不想侵入他人、已经存、或api的bean
 */
public interface BeanContext {
	String getTableName();
	String getIdFieldName();
	IdTypePolicy getIdType();

	/**
	 * 后期这个接口需要拆出去直接在泛型里获取
	 * @return
	 */
	Class getBeanClass();
}
