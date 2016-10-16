package com.landian.sql.jpa.sql;

import java.io.Serializable;

/**
 * 选择SQL片段接口
 * date 15/08/26
 */
public interface SelectUnit extends Serializable {
	/**
	 * SQL片段 
	 */
	String SQL();
}
