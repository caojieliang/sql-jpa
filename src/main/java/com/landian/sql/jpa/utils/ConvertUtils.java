package com.landian.sql.jpa.utils;


import java.math.BigDecimal;
import java.util.*;

public class ConvertUtils {
	public static List<Long> Int2long(List<Integer> srcList){
		List<Long> targetList = new ArrayList<Long>();
		if(null != srcList && srcList.size() > 0){
			for(Integer value : srcList){
				if(null != value){
					targetList.add(value.longValue());
				}
			}
		}
		return targetList;
	}

	public static Map<Integer, Integer> long2IntMap4IntKey(Map<Integer, Long> srcMap){
		Map<Integer, Integer> targetMap = new HashMap<Integer, Integer>();
		if(null != srcMap && srcMap.size() > 0){
			Iterator<Integer> iterator = srcMap.keySet().iterator();
			while (iterator.hasNext()){
				int key = iterator.next();
				int value = srcMap.get(key).intValue();
				targetMap.put(key,value);
			}
		}
		return targetMap;
	}

	public static Map<Integer, Integer> bigDecimal2IntMap4IntKey(Map<Integer, BigDecimal> srcMap){
		Map<Integer, Integer> targetMap = new HashMap<Integer, Integer>();
		if(null != srcMap && srcMap.size() > 0){
			Iterator<Integer> iterator = srcMap.keySet().iterator();
			while (iterator.hasNext()){
				int key = iterator.next();
				int value = srcMap.get(key).intValue();
				targetMap.put(key,value);
			}
		}
		return targetMap;
	}

	public static Map<Integer, Integer> bigDecimal2IntMap4LongKey(Map<Long, BigDecimal> srcMap){
		Map<Integer, Integer> targetMap = new HashMap<Integer, Integer>();
		if(null != srcMap && srcMap.size() > 0){
			Iterator<Long> iterator = srcMap.keySet().iterator();
			while (iterator.hasNext()){
				Long key = iterator.next();
				if(null != key){
					int value = srcMap.get(key).intValue();
					targetMap.put(key.intValue(),value);
				}
			}
		}
		return targetMap;
	}

	public static Map<Long, Integer> toLongIntMap(Map<Long, BigDecimal> srcMap){
		Map<Long, Integer> targetMap = new HashMap<Long, Integer>();
		if(null != srcMap && srcMap.size() > 0){
			Iterator<Long> iterator = srcMap.keySet().iterator();
			while (iterator.hasNext()){
				Long key = iterator.next();
				if(null != key){
					int value = srcMap.get(key).intValue();
					targetMap.put(key,value);
				}
			}
		}
		return targetMap;
	}

	public static Map<Integer, Integer> toIntIntMap(Map<Long, Integer> srcMap){
		Map<Integer, Integer> targetMap = new HashMap<Integer, Integer>();
		if(null != srcMap && srcMap.size() > 0){
			Iterator<Long> iterator = srcMap.keySet().iterator();
			while (iterator.hasNext()){
				Long key = iterator.next();
				if(null != key){
					int value = srcMap.get(key).intValue();
					targetMap.put(key.intValue(),value);
				}
			}
		}
		return targetMap;
	}

}
