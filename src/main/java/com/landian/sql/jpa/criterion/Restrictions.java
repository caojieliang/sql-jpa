package com.landian.sql.jpa.criterion;

import com.landian.sql.jpa.annotation.DateRangeTypePolicy;
import com.landian.sql.jpa.context.JavaType;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


/**
 * 条件建造厂(限制建造器)
 * to be continue
 */
public class Restrictions {

	/**
	 * isNull
	 */
	public static Criterion isNull(String column){
		return new CriterionIsNull(column);
	}

	/**
	 * 等于 
	 */
	public static Criterion eq(String column, String value){
		return new CriterionEqual(column, value, JavaType.STRING);
	}
	/**
	 * 等于 
	 */
	public static Criterion eq(String column, int value){
		return new CriterionEqual(column, value, JavaType.INT);
	}
	/**
	 * 等于 
	 */
	public static Criterion eq(String column, long value){
		return new CriterionEqual(column, value, JavaType.LONG);
	}

	private static Object getFirst(Collection values){
		//Object object = values.stream().findFirst().get();
		Object object = values.iterator().next();
		return object;
	}

	/**
	 *
	 * @param column
	 * @param values
	 */
	public static Criterion notIn(String column, Collection values){
		if(CollectionUtils.isEmpty(values)){
			throw new RuntimeException("条件列表对像不能为空!");
		}
//		Object object = values.stream().findFirst().get();
		Object object = getFirst(values);
		JavaType type;
		if(object instanceof Integer){
			type = JavaType.INT;
		}else if(object instanceof Long){
			type = JavaType.LONG;
		}else if(object instanceof String){
			type = JavaType.STRING;
		}else{
			throw new RuntimeException("条件列表类型不合法！");
		}
		return new CriterionNotIn(column, values, type);
	}

	/**
	 *
	 * @param column
	 * @param valueArray
	 */
	public static Criterion notIn(String column, Object[] valueArray) {
		if(null == valueArray || valueArray.length < 1){
			throw new RuntimeException("条件列表对像不能为空!");
		}
		Object object = valueArray[0];
		JavaType type;
		if(object instanceof Integer){
			type = JavaType.INT;
		}else if(object instanceof Long){
			type = JavaType.LONG;
		}else if(object instanceof String){
			type = JavaType.STRING;
		}else{
			throw new RuntimeException("条件列表类型不合法！");
		}
		return new CriterionNotIn(column, valueArray, type);
	}

	/**
	 *
	 * @param column
	 * @param values
	 * @param defaultValue 默认值
	 * @return
	 */
	public static Criterion notIn(String column, Collection values, int defaultValue){
		if(CollectionUtils.isEmpty(values)){
			values = new ArrayList();
			values.add(defaultValue);
		}
		return new CriterionNotIn(column, values, JavaType.INT);
	}

	/**
	 *
	 * @param column
	 * @param values
	 * @param defaultValue 默认值
	 * @return
	 */
	public static Criterion notIn(String column, Collection values, long defaultValue){
		if(CollectionUtils.isEmpty(values)){
			values = new ArrayList();
			values.add(defaultValue);
		}
		return new CriterionNotIn(column, values, JavaType.LONG);
	}

	/**
	 *
	 * @param column
	 * @param valueArray
	 */
	public static Criterion notIn(String column, Object[] valueArray, long defaultValue) {
		List<Long> values = new ArrayList();
		if(null != valueArray){
			for(int i=0; i<valueArray.length; i++){
				Object value = valueArray[i];
				if(value instanceof Long){
					values.add((Long)value);
				}
			}
		}
		return notIn(column, values, defaultValue);
	}

	/**
	 *
	 * @param column
	 * @param valueArray
	 */
	public static Criterion notIn(String column, Object[] valueArray, int defaultValue) {
		List<Integer> values = new ArrayList<Integer>();
		if(null != valueArray){
			for(int i=0; i<valueArray.length; i++){
				Object value = valueArray[i];
				if(value instanceof Integer){
					values.add((Integer)value);
				}
			}
		}
		return notIn(column, values, defaultValue);
	}

	/**
	 *
	 * @param column
	 * @param values
	 * @return
	 */
	public static Criterion in(String column, int... values){
		List<Integer> collections = new ArrayList<Integer>();
		for (int value : values) {
			collections.add(value);
		}
		return in(column, collections);
	}

	/**
	 *
	 * @param column
	 * @param values
	 * @param defaultValue 默认值
	 * @return
	 */
	public static Criterion in(String column, Collection values, int defaultValue){
		if(CollectionUtils.isEmpty(values)){
			values = new ArrayList();
			values.add(defaultValue);
		}
		return in(column, values);
	}

	/**
	 *
	 * @param column
	 * @param values
	 * @param defaultValue 默认值
	 * @return
	 */
	public static Criterion in(String column, Collection values, long defaultValue){
		if(CollectionUtils.isEmpty(values)){
			values = new ArrayList();
			values.add(defaultValue);
		}
		return in(column, values);
	}

	/**
	 * IN
	 * date 15/12/30
	 */
	public static Criterion in(String column, Collection values){
		if(CollectionUtils.isEmpty(values)){
			throw new RuntimeException("条件列表对像不能为空!");
		}
		Object object = getFirst(values);
		JavaType type;
		if(object instanceof Integer){
			type = JavaType.INT;
		}else if(object instanceof Long){
			type = JavaType.LONG;
		}else if(object instanceof String){
			type = JavaType.STRING;
		}else{
			throw new RuntimeException("条件列表类型不合法！");
		}
		return new CriterionIn(column, values, type);
	}

	/**
	 * IN
	 * date 15/12/30
	 */
	public static Criterion in(String column, Object[] valueArray) {
		if(null == valueArray || valueArray.length < 1){
			throw new RuntimeException("条件列表对像不能为空!");
		}
		Object object = valueArray[0];
		JavaType type;
		if(object instanceof Integer){
			type = JavaType.INT;
		}else if(object instanceof Long){
			type = JavaType.LONG;
		}else if(object instanceof String){
			type = JavaType.STRING;
		}else{
			throw new RuntimeException("条件列表类型不合法！");
		}
		return new CriterionIn(column, valueArray, type);
	}

	/**
	 * like
	 */
	public static Criterion like(String column, String value){
		return new CriterionLike(column, value);
	}

	/**
	 * 日期范围
	 * 目前只支持日期型 yyyy-MM-dd
	 * see com.qmsk.bossRefator.base.proxy.annotation.DateRangeTypePolicy
	 */
	public static Criterion dateBetween(String column, String beginTime, String endTime){
		return new CriterionDateBetween(column, beginTime, endTime, DateRangeTypePolicy.DATE);
	}

	/**
	 * 大于等于某个日期
	 * 目前只支持日期型 yyyy-MM-dd
	 */
	public static Criterion dateGe(String column, String dateTime){
		return new CriterionDateGe(column, dateTime);
	}

	/**
	 * 大于等于某个日期
	 * 目前只支持日期型 yyyy-MM-dd
	 */
	public static Criterion dateGe(String column, Date date){
		return new CriterionDateGe(column, date);
	}

	/**
	 * 大于等于某个日期
	 * 目前只支持日期型 yyyy-MM-dd HH:mm:ss
	 */
	public static Criterion dateTimeGe(String column, Date date){
		return new CriterionDateTimeGe(column, date);
	}

	/**
	 * 大于等于
	 */
	public static Criterion ge(String column, int value){
		return new CriterionGe(column, value);
	}

	/**
	 * 小于等于
	 */
	public static Criterion le(String column, int value){
		return new CriterionLe(column, value);
	}

	/**
	 * 小于等于某个日期
	 * 目前只支持日期型 yyyy-MM-dd
	 */
	public static Criterion dateLe(String column, String dateTime){
		return new CriterionDateLe(column, dateTime);
	}

	/**
	 * 小于等于某个日期
	 * 目前只支持日期型 yyyy-MM-dd
	 */
	public static Criterion dateLe(String column, Date date){
		return new CriterionDateLe(column, date);
	}

	/**
	 * 小于等于某个日期
	 * 目前只支持日期型 yyyy-MM-dd HH:mm:ss
	 */
	public static Criterion dateTimeLe(String column, Date date){
		return new CriterionDateTimeLe(column, date);
	}

	/**
	 * 或
	 * date 15/08/26
	 */
	public static Criterion or(Criterion firstCriterion, Criterion secondCriterion){
		return new CriterionOr(firstCriterion, secondCriterion);
	}

	/**
	 * 自定义
	 */
	public static Criterion sql(String sql){
		return new CriterionSQL(sql);
	}

}
