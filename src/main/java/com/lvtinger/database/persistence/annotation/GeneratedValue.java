package com.lvtinger.database.persistence.annotation;

public @interface GeneratedValue {
    GenerationType strategy() default  GenerationType.AUTO;
    String generator() default "";
}
