package com.landian.sql.jpa.sql;

import java.util.ArrayList;
import java.util.List;


/**
 * 选择单元追加器
 * date 15/08/26
 */
public class SelectUnitAppender{
	
	/**
	 *  
	 */
	public static SelectUnitAppender newInstance(){
		return new SelectUnitAppender();
	}
	
	/**
	 * 选择单元容器
	 */
	public List<SelectUnit> selectUnitList = new ArrayList<SelectUnit>();

	/**
	 * 增加SQL选择单元
	 */
	public SelectUnitAppender sql(String sql){
		selectUnitList.add(SelectUnitRestrictions.sql(sql));
		return this;
	}

	/**
	 * 增加字段选择单元
	 */
	public SelectUnitAppender column(String column){
		selectUnitList.add(SelectUnitRestrictions.column(column));
		return this;
	}

	/**
	 * 选择单元
	 */
	public SelectUnitAppender select(SelectUnit... selectUnits){
		if(null != selectUnits){
			for (SelectUnit selectUnit : selectUnits) {
				selectUnitList.add(selectUnit);
			}
		}
		return this;
	}

	/**
	 * 返回列表 
	 */
	public List<SelectUnit> getSelectUnits(){
		return selectUnitList;
	}
}
