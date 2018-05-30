package com.lvtinger.database.persistence.annotation;

/**
 * 实体
 */
public @interface Entity {
    /**
     * 名称
     * @return
     */
    String name() default "";
}