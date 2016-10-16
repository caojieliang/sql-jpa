package com.landian.sql.jpa.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 排序追加器
 */
public class OrderAppender implements Serializable {
	/**
	 * 实例
	 */
	public static OrderAppender newInstance(){
		return new OrderAppender();
	}
	
	/**
	 * 追加条件容器
	 */
	public List<Order> orderList = new ArrayList<Order>();

	/**
	 * 降序追加排序
	 */
	public OrderAppender desc(String property){
		return this.add(Order.desc(property));
	}

	/**
	 * 升序追加排序
	 */
	public OrderAppender asc(String property){
		return this.add(Order.asc(property));
	}
	
	/**
	 * 添加条件 
	 */
	@Deprecated
	public OrderAppender addOrder(Order order){
		return add(order);
	}

	/**
	 * 添加条件
	 */
	public OrderAppender add(Order order){
		orderList.add(order);
		return this;
	}

	/**
	 * 添加条件
	 */
	public OrderAppender add(Order... orders){
		if(null != orders){
			for (Order order : orders) {
				orderList.add(order);
			}
		}
		return this;
	}

	/**
	 * 容器列表
	 */
	public List<Order> getOrders(){
		return orderList;
	}
}
