package com.lvtinger.database.persistence.annotation;

public enum GenerationType {
    /**
     * 主键由程序控制
     */
    AUTO,
    /**
     * 借助指定数据表生成
     */
    TABLE,
    /**
     * 数据库表自增
     */
    IDENTITY,
    /**
     * 数据库序列器生成
     */
    SEQUENCE,

}
