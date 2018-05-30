package com.lvtinger.database.persistence.annotation;

/**
 * 枚举默认处理
 */
public @interface Enumerated {
    EnumType value() default EnumType.ORDINAL;
}