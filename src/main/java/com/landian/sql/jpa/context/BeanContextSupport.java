package com.landian.sql.jpa.context;

import com.landian.sql.jpa.annotation.IdTypePolicy;
import lombok.Getter;


public class BeanContextSupport implements BeanContext {

    @Getter
    private String tableName;
    @Getter
    private String idFieldName;
    @Getter
    private IdTypePolicy idType;
    @Getter
    private Class beanClass;

    public static BeanContext newInstance(String tableName, String idFieldName,
                                             IdTypePolicy idType, Class beanClass){
        BeanContext beanContext = new BeanContextSupport(tableName, idFieldName, idType, beanClass);
        return beanContext;
    }

    private BeanContextSupport(String tableName, String idFieldName,
                               IdTypePolicy idType, Class beanClass){
        this.tableName = tableName;
        this.idFieldName = idFieldName;
        this.idType = idType;
        this.beanClass = beanClass;
    }
}
