package com.landian.sql.jpa.criterion;


import org.apache.commons.lang.StringUtils;

/**
 * 或条件SQL片段
 * date 15/08/20 
 */
public class CriterionOr implements Criterion {
	
	private static final long serialVersionUID = 1L;

	public CriterionOr(Criterion criterionA, Criterion criterionB) {
		this.criterionA = criterionA;
		this.criterionB = criterionB;
	}
	
	/**
	 * 条件A
	 */
	private Criterion criterionA;
	/**
	 * 条件B
	 */
	private Criterion criterionB;

	/**
	 * SQL片段 
	 */
	public String SQL(){
		if(StringUtils.isNotBlank(criterionA.SQL()) &&
				StringUtils.isNotBlank(criterionB.SQL())){
			return "(" + criterionA.SQL() + " or " + criterionB.SQL() + ")";
		}
		return "";
	}
}
