package com.lvtinger.converter;

import com.lvtinger.common.ReflectionUtils;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConverterFactory {

    private final static Map<String, Converter<?, ?>> HOLDER = new ConcurrentHashMap<String, Converter<?, ?>>();

    private static class Loader extends ClassLoader{
        public final static Loader instance = new Loader();

        public Class<?> define(String name, byte[] bytes){
            return this.defineClass(name, bytes, 0, bytes.length);
        }
    }

    public static <T, R> Converter<T, R> get(Class<T> target, Class<R> result) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(target.getName());
        stringBuilder.append("To");
        stringBuilder.append(result.getName());

        Converter<T, R> converter = (Converter<T, R>)HOLDER.get(stringBuilder.toString());

        if(converter == null){
            converter = generate(target, result);
        }

        return converter;

    }

    private static <T, R> Converter<T, R> generate(Class<T> target, Class<R> result){

        Field[] targetFields = ReflectionUtils.getFields(target);
        Field[] resultFields = ReflectionUtils.getFields(result);


        //定义类名
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(target.getSimpleName());
        stringBuilder.append("_TO_");
        stringBuilder.append(result.getSimpleName());

        String className = stringBuilder.toString();

        //定义类
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        classWriter.visit(Opcodes.V1_8,
                Opcodes.ACC_PUBLIC,
                className,
                null,
                "java/lang/Object",
                null);

        //定义构造函数
        MethodVisitor methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC,
                "<init>",
                "()V",
                null,
                null);
        methodVisitor.visitCode();
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
        methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
        methodVisitor.visitInsn(Opcodes.RETURN);
        methodVisitor.visitMaxs(1,1);
        methodVisitor.visitEnd();

        stringBuilder.delete(0, stringBuilder.length());

        String resultName = result.getName().replace("\\.", "/");
        String targetName = target.getName().replace("\\.", "/");

        stringBuilder.append("(L");
        stringBuilder.append(targetName);
        stringBuilder.append(";)L");
        stringBuilder.append(resultName);
        stringBuilder.append(";");

        //定义转换函数
        methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC,
                "convert",
                stringBuilder.toString(),
                null, null);

        //实例化目标值
        methodVisitor.visitTypeInsn(Opcodes.NEW, resultName);
        methodVisitor.visitInsn(Opcodes.DUP);
        methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, resultName, "<init>", "()V");
        methodVisitor.visitVarInsn(Opcodes.ASTORE, 2);


        //返回结果
        methodVisitor.visitVarInsn(Opcodes.ALOAD, 2);
        methodVisitor.visitInsn(Opcodes.ARETURN);


        methodVisitor.visitMaxs(2,3);
        methodVisitor.visitEnd();


        byte[] bytes = classWriter.toByteArray();

        Class<?> define = Loader.instance.define(className, bytes);

        try {
            return (Converter<T, R>) define.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
