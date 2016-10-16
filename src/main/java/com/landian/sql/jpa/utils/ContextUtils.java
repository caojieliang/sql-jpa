package com.landian.sql.jpa.utils;

import javassist.Modifier;
import com.landian.sql.jpa.annotation.Transient;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2016/8/30.
 */
public class ContextUtils {

    public static boolean needToBuildField(Field field, String fieldName){
        //0.忽略透明注解属性
        Transient transientAnnotations = field.getAnnotation(Transient.class);
        if(null != transientAnnotations){
            return false;
        }
        if(isIgnoreField(field, fieldName)){
            return false;
        }
        return true;
    }

    /*	由于基本类型存在默认值(不好识别是否为空)，笔者决定在设计实现上不解释基本类型
 */
    public static boolean isIgnoreField(Field field,String fieldName) {
        if("serialVersionUID".equals(fieldName)) { // 过滤serialVersionUID此属性
            return true;
        }
        if(Modifier.isStatic(field.getModifiers())) { //过滤静态属性
            return true;
        }
        if(field.getType() == int.class || field.getType() == long.class ||
                field.getType() == double.class || field.getType() == short.class ||
                field.getType() == byte.class || field.getType() == float.class ||
                field.getType() == boolean.class || field.getType() == char.class){
            return true;
        }
        return false;
    }
}
