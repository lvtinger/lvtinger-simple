package com.lvtinger.database.persistence.annotation;

public @interface Temporal {
    TemporalType value() default TemporalType.DATE;
}
