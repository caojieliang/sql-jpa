package com.landian.sql.jpa.order;


import lombok.Data;

import java.io.Serializable;

@Data
public class OrderVo implements Serializable {
	/**
	 *
	 */
	private String order;
	/**
	 *
	 */
	private String sort;
}
