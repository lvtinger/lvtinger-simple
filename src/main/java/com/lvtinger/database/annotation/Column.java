package com.lvtinger.database.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    String value() default "";
    boolean ignore() default false;
    int type() default 0;
    int attr() default 0;

    int primaryKey = 1;
    int statusColumn= 2;
    int createTimeColumn = 3;
    int updateTimeColumn = 4;
}
