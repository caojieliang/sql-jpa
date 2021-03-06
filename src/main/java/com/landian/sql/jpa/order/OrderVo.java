package com.landian.sql.jpa.order;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "OrderVo", description = "OrderVo")
public class OrderVo implements Serializable {

	public static OrderVo desc(String sort){
		return newInstance(sort,"DESC");
	}

	public static OrderVo asc(String sort){
		return newInstance(sort,"ASC");
	}

	private static OrderVo newInstance(String sort, String order){
		return OrderVo.builder().sort(sort).order(order).build();
	}

	@ApiModelProperty(value = "排序规则", dataType = "string", example="asc", required = true, allowableValues="asc,desc")
	private String order;

	@ApiModelProperty(value = "排序字段", dataType = "string", required = true)
	private String sort;
}
