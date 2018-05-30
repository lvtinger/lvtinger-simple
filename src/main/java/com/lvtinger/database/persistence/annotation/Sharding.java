package com.lvtinger.database.persistence.annotation;


public @interface Sharding {
    ShardMode mode() default ShardMode.NOTHING;
    String algorithm() default "";
}
