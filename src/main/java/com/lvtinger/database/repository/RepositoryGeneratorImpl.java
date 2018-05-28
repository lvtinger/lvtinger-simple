package com.lvtinger.database.repository;

import com.lvtinger.assembly.ClassBuilder;
import com.lvtinger.common.StringUtils;
import com.lvtinger.database.annotation.Column;
import com.lvtinger.database.annotation.Database;
import com.lvtinger.database.annotation.Identity;
import com.lvtinger.database.annotation.Table;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.Map;

public class RepositoryGeneratorImpl implements RepositoryGenerator {
    @Override
    public Class generate(Class repository, Class persistentObject) {

        String typeName = Type.getInternalName(repository) + "Impl";
        ClassBuilder builder = ClassBuilder.init(typeName, Object.class, repository)
                .field("connection", Connection.class)
                .setter("connection", Connection.class);

        MethodVisitor visitor = builder.visitor("insert", boolean.class, persistentObject);

        return null;
    }

    private static class Metadata {
        private Class<?> clazz;
        private String tableName;
        private String database;
        private Map<String, Property> properties;

        public static Metadata resolve(Class clazz) {
            Metadata metadata = new Metadata();
            Database database = (Database) clazz.getAnnotation(Database.class);
            if (database == null || StringUtils.isEmpty(database.value())) {
                metadata.database = StringUtils.firstToLower(clazz.getSimpleName());
            } else {
                metadata.database = database.value();
            }

            Table table = (Table) clazz.getAnnotation(Table.class);
            if (table == null || StringUtils.isEmpty(table.value())) {
                metadata.database = StringUtils.firstToLower(clazz.getSimpleName());
            } else {
                metadata.database = table.value();
            }


            return metadata;
        }

    }

    private static class Property {
        private String name;
        private String column;
        private Class type;
        private boolean primaryKey;
        private boolean generate;

        public static void resolve(Metadata metadata ,Field field){
            Column column = field.getAnnotation(Column.class);
            String columnName = null;
            if(column == null || StringUtils.isEmpty(column.value())){
                columnName = StringUtils.firstToLower(field.getName());
            } else {
                if(column.ignore() == false){
                    return;
                }
                columnName = column.value();
            }

            Property property = new Property();
            property.name = columnName;
            property.type = field.getType();
            property.column = field.getName();

            Identity identity = field.getAnnotation(Identity.class);
            if(identity != null){
                property.primaryKey = true;
                property.generate = identity.autoGenerate();
            }
        }
    }
}
