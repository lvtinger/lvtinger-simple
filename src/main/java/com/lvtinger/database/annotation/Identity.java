package com.lvtinger.database.annotation;

public @interface Identity {
    boolean autoGenerate() default true;
}