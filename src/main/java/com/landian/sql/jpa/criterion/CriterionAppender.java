package com.landian.sql.jpa.criterion;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 条件追加器
 */
public class CriterionAppender{
	
	/**
	 *  
	 */
	public static CriterionAppender newInstance(){
		return new CriterionAppender();
	}
	
	/**
	 * 追加条件容器
	 */
	public List<Criterion> criterionList = new ArrayList<Criterion>();
	
	/**
	 * 添加条件 
	 */
	@Deprecated
	public CriterionAppender addCriterion(Criterion criterion){
		return add(criterion);
	}

	/**
	 * 添加条件
	 */
	public CriterionAppender add(Criterion criterion){
		criterionList.add(criterion);
		return this;
	}

	/**
	 * 添加条件
	 */
	public CriterionAppender add(Criterion... criterions){
		if(null != criterions){
			for (Criterion criterion : criterions) {
				criterionList.add(criterion);
			}
		}
		return this;
	}

	@Deprecated
	public CriterionAppender addCriterion(List<Criterion> criterions){
		return add(criterions);
	}

	/**
	 * 添加条件 
	 */
	public CriterionAppender add(List<Criterion> criterions){
		if(CollectionUtils.isNotEmpty(criterions)){
			for(Criterion cri : criterions){
				if(null != cri){
					criterionList.add(cri);
				}
			}
		}
		return this;
	}
	
	
	
	/**
	 * 返回条件列表 
	 */
	public List<Criterion> getCriterions(){
		return criterionList;
	}
}
