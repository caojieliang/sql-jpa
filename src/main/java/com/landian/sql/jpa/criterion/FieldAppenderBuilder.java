package com.landian.sql.jpa.criterion;


/**
 * FieldAppenderBuilder
 */
public class FieldAppenderBuilder {
	
	public static FieldAppender buildByField(String ... fieldNames){
		FieldAppender fieldAppender = FieldAppender.newInstance();
		for (String fieldName : fieldNames){
			fieldAppender.addField(Field.newInstance(fieldName));
		}
		return fieldAppender;
	}
}
