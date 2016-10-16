package com.landian.sql.jpa.context;

import lombok.Getter;

/**
 * 条件字段类型
 * to be continute
 */
public enum JavaType {
    INT(1,"INT"),

    LONG(2,"LONG"),

    STRING(3,"STRING"),
    
    DATE(4,"DATE"),

    FLOAT(5,"FLOAT"),

    BIGDECIMAL(6,"BIGDECIMAL"),

    DOUBLE(7,"DOUBLE");

    @Getter
    private int index;

    @Getter
    private String description;

    JavaType(int index, String description) {
        this.index = index;
        this.description = description;
    }

    public static JavaType getReturnGoodsListType(int index) {
        for (JavaType type : values()) {
            if (type.getIndex() == index) {
                return type;
            }
        }
        return null;
    }

}
