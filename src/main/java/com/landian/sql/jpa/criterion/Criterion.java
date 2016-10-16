package com.landian.sql.jpa.criterion;

import java.io.Serializable;

/**
 * 条件SQL片段接口
 * date 15/07/27
 */
public interface Criterion extends Serializable {
	/**
	 * SQL片段 
	 */
	public String SQL();
}
