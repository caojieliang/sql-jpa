package com.landian.sql.jpa.criterion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
/**
 * 财务统计经常需要用到时期范围，封装一个类
 * format 2015-06-18
 */
public class DateRange implements Serializable{
	private static DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * 开始时间
	 */
	private String beginDate;
	/**
	 * 结束时间
	 */
	private String endDate;
	
	public static DateRange getInstance(Date beginDate,Date endDate){
		String beginDateTime = dfm.format(beginDate);
    	String endDateTime = dfm.format(endDate);
		return DateRange.builder().beginDate(beginDateTime).endDate(endDateTime).build();
	}
	public static DateRange getInstance(String beginDate,String endDate){
		return DateRange.builder().beginDate(beginDate).endDate(endDate).build();
	}
	
	/**
	 * 转换为查询条件列表
	 * @return
	 */
	public List<Criterion> toCriterionList(String column){
		List<Criterion> criterionList = new ArrayList<Criterion>();
		if(StringUtils.isNotBlank(beginDate)){
			criterionList.add(Restrictions.dateGe(column, beginDate));
		}
		if(StringUtils.isNotBlank(endDate)){
			criterionList.add(Restrictions.dateLe(column, endDate));
		}
		return criterionList;
	}
}
