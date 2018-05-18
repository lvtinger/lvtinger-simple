package com.lvtinger.common;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 反射工具类
 */
public class ReflectionUtils {

    private final static Field[] FIELD_NONE = new Field[0];
    private final static Map<Class, Field[]> fieldCached = new ConcurrentHashMap<Class, Field[]>();

    /**
     * 获取字段
     *
     * @param clazz
     * @return
     */
    public final static Field[] getFields(final Class clazz) {
        Field[] array = fieldCached.get(clazz);

        if (array == null) {
            Class current = clazz;
            List<Field> list = new LinkedList<Field>();
            while (!current.equals(Object.class)) {
                list.addAll(Arrays.asList(current.getDeclaredFields()));
                current = current.getSuperclass();
            }

            array = list.size() > 0
                    ? list.toArray(new Field[list.size()])
                    : FIELD_NONE;

            fieldCached.put(clazz, array);
        }
        return array;
    }

}
