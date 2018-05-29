package com.lvtinger.database.annotation;

/**
 * 数据表
 */
public @interface Table {
    /**
     * 表名
     *
     * @return
     */
    String name() default "";

    /**
     * 数据库
     *
     * @return
     */
    String schema() default "";
}
