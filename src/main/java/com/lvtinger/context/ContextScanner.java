package com.lvtinger.context;

public interface ContextScanner {
    void filter(Class clazz);
    void process(Class clazz);
}