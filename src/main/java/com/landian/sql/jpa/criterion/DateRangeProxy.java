package com.landian.sql.jpa.criterion;

import java.util.ArrayList;
import java.util.List;


/**
 */
public class DateRangeProxy {
	/**
	 * 转换为查询条件列表
	 * @return
	 */
	public static List<Criterion> toCriterionList(String column,DateRange dateRange){
		List<Criterion> criterionList = new ArrayList<Criterion>();
		if(null != dateRange){
			return dateRange.toCriterionList(column);
		}
		return criterionList;
	}
}
