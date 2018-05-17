package com.lvtinger.assembly;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.lang.reflect.Method;

public class ClassBuilder extends ClassLoader implements Opcodes {

    private ClassWriter writer;
    private String className;

    private ClassBuilder() {
    }

    public static ClassBuilder init(String name) {
        return new ClassBuilder()
                .define(name, Object.class, null);
    }

    public static ClassBuilder init(String name, Class<?> superClass) {
        return new ClassBuilder()
                .define(name, superClass, null);
    }

    public static ClassBuilder init(String name, Class<?> superClass, Class... interfaces) {
        return new ClassBuilder()
                .define(name, superClass, interfaces);
    }

    private ClassBuilder define(String name, Class<?> superClass, Class... interfaces) {
        this.className = name;
        writer = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        writer.visit(V1_8, ACC_PUBLIC, name, null,
                Type.getInternalName(superClass),
                TypeExtend.getInternalName(interfaces));

        MethodVisitor visitor = writer.visitMethod(ACC_PUBLIC,
                "<init>",
                Type.getMethodDescriptor(Type.VOID_TYPE),
                null,
                null);
        visitor.visitVarInsn(ALOAD, 0);
        visitor.visitMethodInsn(INVOKESPECIAL,
                Type.getInternalName(Object.class), "<init>",
                Type.getMethodDescriptor(Type.VOID_TYPE),
                false);
        visitor.visitInsn(RETURN);

        visitor.visitMaxs(1, 1);
        visitor.visitEnd();

        return this;
    }

    public ClassBuilder property(String name, Class<?> type){
        field(name, type)
                .setter(name, type)
                .getter(name, type);
        return this;
    }

    public ClassBuilder field(String name, Class<?> type) {
        writer.visitField(ACC_PRIVATE, name, Type.getDescriptor(type), null, null);
        return this;
    }

    public ClassBuilder getter(String name, Class<?> type) {
        String methodName = name.length() == 1
                ? "get" + name.toUpperCase()
                : "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
        MethodVisitor visitor = this.visitor(methodName, type);
        visitor.visitVarInsn(ALOAD, 0);
        visitor.visitFieldInsn(GETFIELD, className, name, Type.getDescriptor(type));
        visitor.visitInsn(ARETURN);
        visitor.visitMaxs(1, 1);
        return this;
    }

    public ClassBuilder setter(String name, Class<?> type) {
        String methodName = name.length() == 1
                ? "get" + name.toUpperCase()
                : "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
        MethodVisitor visitor = this.visitor(methodName, void.class, type);
        visitor.visitVarInsn(ALOAD, 0);
        visitor.visitVarInsn(ALOAD, 1);
        visitor.visitFieldInsn(PUTFIELD, className, name, Type.getDescriptor(type));
        visitor.visitInsn(RETURN);
        visitor.visitMaxs(2, 2);
        visitor.visitEnd();
        return this;
    }

    public MethodVisitor visitor(String name, Class<?> returnType, Class<?>... parameters) {
        return visitor(name, returnType, parameters, null);
    }

    public MethodVisitor visitor(String name, Class<?> returnType, Class<?>[] parameters, Class<?>... exceptions) {

        return writer.visitMethod(ACC_PUBLIC,
                name,
                TypeExtend.getMethodDescriptor(returnType, parameters),
                null,
                TypeExtend.getInternalName(exceptions));

    }

    public Class<?> build() {
        byte[] bytes = this.writer.toByteArray();
        return this.defineClass(this.className, bytes, 0, bytes.length);
    }
}