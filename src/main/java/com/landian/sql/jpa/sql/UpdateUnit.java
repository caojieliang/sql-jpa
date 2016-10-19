package com.landian.sql.jpa.sql;

import java.io.Serializable;

/**
 * 条件SQL片段接口
 */
public interface UpdateUnit extends Serializable {
	/**
	 * SQL片段 
	 */
	String SQL();
}
