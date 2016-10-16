package com.landian.sql.jpa.sql;

import org.apache.commons.collections.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 更新单元追加器
 */
public class UpdateUnitAppender{
	
	/**
	 *  
	 */
	public static UpdateUnitAppender newInstance(){
		return new UpdateUnitAppender();
	}
	
	/**
	 * 更新单元容器
	 */
	public List<UpdateUnit> updateUnitList = new ArrayList<UpdateUnit>();


	/**
	 * 等于
	 */
	public UpdateUnitAppender set(String column, String value){
		return this.add(Update.set(column, value));
	}
	/**
	 * 等于
	 */
	public UpdateUnitAppender set(String column, int value){
		return this.add(Update.set(column, value));
	}
	/**
	 * 等于
	 */
	public UpdateUnitAppender set(String column, long value){
		return this.add(Update.set(column, value));
	}
	/**
	 * 等于
	 */
	public UpdateUnitAppender set(String column, Date value){
		return this.add(Update.set(column, value));
	}
	/**
	 * 等于
	 */
	public UpdateUnitAppender set(String column, float value){
		return this.add(Update.set(column, value));
	}
	/**
	 * 等于
	 */
	public UpdateUnitAppender set(String column, double value){
		return this.add(Update.set(column, value));
	}
	/**
	 * 等于
	 */
	public UpdateUnitAppender set(String column, BigDecimal value){
		return this.add(Update.set(column, value));
	}
	/**
	 * 为空
	 */
	public UpdateUnitAppender setNull(String column){
		return this.add(Update.setNull(column));
	}

	/**
	 * 自定义
	 */
	public UpdateUnitAppender sql(String sql){
		return this.add(Update.sql(sql));
	}


	
	/**
	 * 更新单元 
	 */
	@Deprecated
	public UpdateUnitAppender addUpdateUnit(UpdateUnit updateUnit){
		return add(updateUnit);
	}

	/**
	 * 更新单元
	 */
	public UpdateUnitAppender add(UpdateUnit updateUnit){
		updateUnitList.add(updateUnit);
		return this;
	}

	/**
	 * 更新单元
	 */
	public UpdateUnitAppender add(UpdateUnit... updateUnits){
		if(null != updateUnits){
			for (UpdateUnit updateUnit : updateUnits) {
				updateUnitList.add(updateUnit);
			}
		}
		return this;
	}

	/**
	 * 更新单元 
	 */
	@Deprecated
	public UpdateUnitAppender addUpdateUnit(List<UpdateUnit> updateUnits){
		return add(updateUnits);
	}

	/**
	 * 更新单元
	 */
	public UpdateUnitAppender add(List<UpdateUnit> updateUnits){
		if(CollectionUtils.isNotEmpty(updateUnits)){
			for(UpdateUnit updateUnit : updateUnits){
				if(null != updateUnit){
					updateUnitList.add(updateUnit);
				}
			}
		}
		return this;
	}
	
	
	
	/**
	 * 返回列表 
	 */
	public List<UpdateUnit> getUpdateUnits(){
		return updateUnitList;
	}
}
