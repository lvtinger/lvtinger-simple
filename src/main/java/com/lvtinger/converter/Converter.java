package com.lvtinger.converter;

/**
 * 类转换接口
 *
 * @author qiuxu
 */
public interface Converter<T, R> {
    /**
     * 类转换
     *
     * @param target 需要转换的数据
     * @return 转换的结果
     */
    R convert(T target);
}