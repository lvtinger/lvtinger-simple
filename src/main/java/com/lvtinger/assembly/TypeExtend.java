package com.lvtinger.assembly;

import org.objectweb.asm.Type;

public class TypeExtend {
    private final static Type[] types = new Type[0];

    public static String[] getInternalName(Class... classes) {
        if (classes == null) {
            return null;
        }
        int length = classes.length;
        if (length == 0) {
            return null;
        }

        String[] strings = new String[length];
        for (int i = 0; i < length; i++) {
            strings[i] = Type.getInternalName(classes[i]);
        }

        return strings;
    }

    public static String getMethodDescriptor(Class<?> returnType, Class<?>[] parameterTypes){
        Type $returnType = Type.getType(returnType);
        if(parameterTypes == null || parameterTypes.length == 0){
            return Type.getMethodDescriptor($returnType, types);
        }
        int length = parameterTypes.length;

        Type[] $parameterTypes = new Type[length];
        for (int i = 0; i < length; i++){
            $parameterTypes[i] = Type.getType(parameterTypes[i]);
        }

        return Type.getMethodDescriptor($returnType, $parameterTypes);
    }
}
