package com.lvtinger.database.repository;

import com.lvtinger.assembly.ClassBuilder;

import jdk.internal.org.objectweb.asm.Type;
import org.objectweb.asm.MethodVisitor;
import org.omg.CORBA.PRIVATE_MEMBER;

import javax.print.DocFlavor;
import java.sql.Connection;
import java.util.Map;

public class RepositoryGeneratorImpl implements RepositoryGenerator {
    @Override
    public Class generate(Class repository, Class persistentObject) {

        String typeName = Type.getInternalName(repository)+"Impl";
        ClassBuilder builder = ClassBuilder.init(typeName, Object.class, repository)
                .field("connection", Connection.class)
                .setter("connection", Connection.class);

        MethodVisitor visitor = builder.visitor("insert", boolean.class, persistentObject);

        return null;
    }

    private static class Metadata{
        private Class<?> clazz;
        private String tableName;
        private String database;
    }

    private static class Property {
        private String name;
        private Class type;
        private int attr;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Class getType() {
            return type;
        }

        public void setType(Class type) {
            this.type = type;
        }

        public int getAttr() {
            return attr;
        }

        public void setAttr(int attr) {
            this.attr = attr;
        }
    }
}
