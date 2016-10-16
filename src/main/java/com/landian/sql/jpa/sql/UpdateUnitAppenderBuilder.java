package com.landian.sql.jpa.sql;

import com.landian.sql.jpa.utils.ContextUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 选择单元追加器Builder
 * date 16/07/13
 * to be continue
 * 感觉来了，要将一些东西搬过来了
 */
public class UpdateUnitAppenderBuilder {

	private static final Logger logger = Logger.getLogger(UpdateUnitAppenderBuilder.class);

	/**
	 * 构建更新UpdateUnitAppender
	 * @return
	 */
	public static UpdateUnitAppender buildWithNull(Object updateVo, List<String> ignoreFields){
		return build(updateVo, false, ignoreFields);
	}

	/**
	 * 构建更新UpdateUnitAppender
	 * @return
	 */
	public static UpdateUnitAppender buildWithNull(Object updateVo){
		return build(updateVo, false, Collections.EMPTY_LIST);
	}

	/**
	 * 构建更新UpdateUnitAppender
	 * @return
	 */
	public static UpdateUnitAppender buildWithOutNull(Object updateVo){
		return build(updateVo, true, Collections.EMPTY_LIST);
	}

	/**
	 * 构建更新UpdateUnitAppender
	 * @return
	 */
	public static UpdateUnitAppender buildWithOutNull(Object updateVo, List<String> ignoreFields){
		return build(updateVo, true, ignoreFields);
	}

	/**
     * 构建更新UpdateUnitAppender
	 * @param updateVo 更新Vo
     * @param ignoreNull 是否忽略空值，即空值是否需要更新
     * @param ignoreFields 忽略构建的属性
     * @return
     */
	private static UpdateUnitAppender build(Object updateVo, boolean ignoreNull, List<String> ignoreFields){
		UpdateUnitAppender updateUnitAppender = UpdateUnitAppender.newInstance();
		Class clazz = updateVo.getClass();
		Field[] fields = clazz.getDeclaredFields();
		if(null != fields && fields.length > 0){
			for(Field field : fields){
				//可以访问private
				field.setAccessible(true);
				String fieldName = field.getName();
				//0.忽略透明不需要构建的部分
				if(!ContextUtils.needToBuildField(field, fieldName)){
					continue;
				}
				if(ignoreFields.contains(fieldName)){
					continue;
				}
				Object value = null;
				try {
					value = field.get(updateVo);
				} catch (IllegalAccessException e) {
					String errorMsg = "构建" + updateVo + "属性" + fieldName + "条件异常！";
					logger.error(errorMsg);
					logger.error(e.getMessage(), e);
				}
				if(null != value){ //1.只针对不为空的值建造查询条件
					UpdateUnit updateUnit = buildUpdateUnit(field, fieldName, value);
					if(null != updateUnit){
						updateUnitAppender.add(updateUnit);
					}
				}else{
					if(!ignoreNull){
						UpdateUnit updateUnit = Update.setNull(fieldName);
						updateUnitAppender.add(updateUnit);
					}
				}
			}
		}
		return updateUnitAppender;
	}

	private static UpdateUnit buildUpdateUnit(Field field,String fieldName,Object value){
		//2.默认Java字段与数据字段一置
		String columnName = fieldName;
		//4.只解释构建Integer Long String 类型查询条件
		UpdateUnit updateUnit = null;
		Class fieldType = field.getType();
		if(fieldType == Integer.class){
			Integer intValue = (Integer) value;
			updateUnit = Update.set(columnName, intValue);
		}else if(fieldType == Long.class){
			Long longValue = (Long) value;
			updateUnit = Update.set(columnName, longValue);
		}else if (fieldType == String.class) {
			String stringValue = (String) value;
			updateUnit = Update.set(columnName, stringValue);
		}else if (fieldType == Date.class) {
			Date dateVal = (Date) value;
			updateUnit = Update.set(columnName, dateVal);
		}
		return updateUnit;
	}
}
