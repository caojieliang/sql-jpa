package com.landian.sql.jpa.criterion;


import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 属性追加器
 */
public class FieldAppender {
	
	/**
	 *  
	 */
	public static FieldAppender newInstance(){
		return new FieldAppender();
	}
	
	/**
	 * 追加
	 */
	public List<Field> fieldList = new ArrayList<Field>();
	
	/**
	 * 添加
	 */
	public FieldAppender addField(Field field){
		fieldList.add(field);
		return this;
	}
	
	/**
	 * 添加
	 */
	public FieldAppender addField(List<Field> fields){
		if(CollectionUtils.isNotEmpty(fields)){
			for(Field field : fields){
				if(null != field){
					fieldList.add(field);
				}
			}
		}
		return this;
	}

	/**
	 * 返回列表
	 */
	public List<Field> getFields(){
		return fieldList;
	}
}
