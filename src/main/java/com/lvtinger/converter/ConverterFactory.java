package com.lvtinger.converter;

import com.lvtinger.assembly.ClassBuilder;
import com.lvtinger.assembly.TypeExtend;
import com.lvtinger.common.ReflectionUtils;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * bean转换类，类型相同，名称相同的field可以相互转换
 *
 * @author qiuxu
 */
public class ConverterFactory {

    private final static Set<ConverterWrapper> HOLDER = new ConcurrentSkipListSet<ConverterWrapper>();

    public static <T, R> Converter<T, R> get(Class<T> target, Class<R> result) {
        ConverterWrapper wrapper = HOLDER.stream().filter(x -> x.result.equals(result) && x.target.equals(target))
                .findFirst().orElse(null);
        if (wrapper != null) {
            return (Converter<T, R>) wrapper.converter;
        }

        Converter<T, R> converter = generate(target, result);

        wrapper = new ConverterWrapper(target, result, converter);
        HOLDER.add(wrapper);

        return converter;
    }

    private static <T, R> Converter<T, R> generate(Class<T> target, Class<R> result) {
        String name = generateName(target, result);
        ClassBuilder builder = ClassBuilder.init(name, Object.class, Converter.class);

        MethodVisitor convert = builder.visitor("convert", result, target);

        String resultName = Type.getInternalName(result);
        String targetName = Type.getInternalName(target);

        convert.visitTypeInsn(Opcodes.NEW, resultName);
        convert.visitInsn(Opcodes.DUP);
        convert.visitMethodInsn(Opcodes.INVOKESPECIAL, resultName, "<init>", "()V", false);
        convert.visitVarInsn(Opcodes.ASTORE, 2);

        Field[] targetFieldArray = ReflectionUtils.getFields(target);
        Field[] resultFieldArray = ReflectionUtils.getFields(result);

        if (targetFieldArray.length > 0 && resultFieldArray.length > 0) {
            int targetLength = targetFieldArray.length;
            int resultLength = resultFieldArray.length;

            for (int i = 0; i < targetLength; i++) {
                Field targetField = targetFieldArray[i];
                String targetFieldName = targetField.getName();
                Class<?> targetFieldType = targetField.getType();
                for (int j = 0; j < resultLength; j++) {
                    Field resultField = resultFieldArray[j];
                    if (targetFieldName.equals(resultField.getName())
                            && targetFieldType.equals(resultField.getType())) {

                        String fieldName = targetFieldName.length() == 1
                                ? targetFieldName.toUpperCase()
                                : targetFieldName.substring(0, 1).toUpperCase()
                                + targetFieldName.substring(1);


                        convert.visitVarInsn(Opcodes.LSTORE, 2);
                        convert.visitVarInsn(Opcodes.LSTORE, 1);
                        convert.visitMethodInsn(Opcodes.INVOKEVIRTUAL,
                                targetName,
                                "get" + fieldName,
                                TypeExtend.getMethodDescriptor(targetFieldType, null),
                                false);
                        convert.visitMethodInsn(Opcodes.INVOKEVIRTUAL,
                                resultName,
                                "set" + fieldName,
                                TypeExtend.getMethodDescriptor(void.class, new Class[]{targetFieldType}),
                                false);

                        break;
                    }
                }
            }
        }


        convert.visitVarInsn(Opcodes.ALOAD, 2);
        convert.visitInsn(Opcodes.ARETURN);
        convert.visitEnd();

        Class<?> build = builder.build();

        try {
            return (Converter<T, R>) build.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String generateName(Class target, Class result) {
        StringBuilder builder = new StringBuilder("com.lvtinger.converter.");
        builder.append(TypeExtend.firstToLowerCase(result.getSimpleName()));
        builder.append(".");
        builder.append(target.getSimpleName());
        builder.append(new Random().nextInt(9000) + 1000);
        return builder.toString();
    }

    private static class ConverterWrapper {
        private Class target;
        private Class result;
        private Converter<?, ?> converter;

        public Class getTarget() {
            return target;
        }

        public void setTarget(Class target) {
            this.target = target;
        }

        public Class getResult() {
            return result;
        }

        public void setResult(Class result) {
            this.result = result;
        }

        public Converter<?, ?> getConverter() {
            return converter;
        }

        public void setConverter(Converter<?, ?> converter) {
            this.converter = converter;
        }

        public ConverterWrapper(Class target, Class result, Converter<?, ?> converter) {
            this.target = target;
            this.result = result;
            this.converter = converter;
        }
    }
}