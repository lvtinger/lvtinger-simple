package com.lvtinger.database.annotation;

public @interface GeneratedValue {
    GenerationType strategy() default  GenerationType.AUTO;
    String generator() default "";
}
