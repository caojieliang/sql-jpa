package com.landian.sql.jpa.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DateCriterion {
	DateRangePolicy type();
	DateTypePolicy dateType() default DateTypePolicy.DATE;
	String column();
}
