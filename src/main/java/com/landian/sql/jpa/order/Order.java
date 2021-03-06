package com.landian.sql.jpa.order;


import com.landian.sql.jpa.annotation.OrderPolicy;

import java.io.Serializable;

public class Order implements Serializable {
	public static String ASC = "ASC";
	public static String DESC = "DESC";

	public static Order asc(String property){
		Order proxyOrder = new Order(property, OrderPolicy.ASC);
		return proxyOrder;
	}

	public static Order[] asArray(OrderVo... orderVos){
		if(null == orderVos){
			return new Order[]{};
		}
		Order[] array = new Order[orderVos.length];
		for (int i=0; i<orderVos.length; i++) {
			array[i] = newInstance(orderVos[i]);
		}
		return array;
	}

	public static Order newInstance(OrderVo orderVo){
		if(orderVo.getOrder().equalsIgnoreCase(ASC)){
			return Order.asc(orderVo.getSort());
		}
		return Order.desc(orderVo.getSort());
	}

	public static Order desc(String property){
		Order proxyOrder = new Order(property, OrderPolicy.DESC);
		return proxyOrder;
	}

	/**
	 * 字段
	 */
	private String property;
	/**
	 * 排序方式
	 */
	private OrderPolicy orderExpr;

	private Order(){}

	private Order(String property, OrderPolicy orderExpr) {
		this.property = property;
		this.orderExpr = orderExpr;
	}

	public String getProperty() {
		return property;
	}

	public OrderPolicy getOrderExpr() {
		return orderExpr;
	}
	
	public String getSortKey(){
		if(OrderPolicy.ASC == orderExpr){
			return ASC;
		}
		return DESC;
	}
	
	/**
	 * 排序SQL 
	 */
	public String nativeSQL(){
		return getProperty() + " " + getSortKey();
	}
}
