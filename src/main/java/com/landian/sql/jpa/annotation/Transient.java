package com.landian.sql.jpa.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//import javax.persistence.Transient;没有引入javax Transient类，自己实现一个
@Retention(RetentionPolicy.RUNTIME)
public @interface Transient {
}
