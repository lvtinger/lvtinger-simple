package com.lvtinger.converter;

public interface Converter<T, R> {
    R convert(T target);
}