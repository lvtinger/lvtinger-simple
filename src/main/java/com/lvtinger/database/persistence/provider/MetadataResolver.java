package com.lvtinger.database.persistence.provider;

import com.lvtinger.common.ReflectionUtils;
import com.lvtinger.common.StringUtils;
import com.lvtinger.database.persistence.annotation.Column;
import com.lvtinger.database.persistence.annotation.Id;
import com.lvtinger.database.persistence.annotation.Table;
import com.lvtinger.database.persistence.annotation.Transient;
import com.lvtinger.database.persistence.metadata.Metadata;
import com.lvtinger.database.persistence.metadata.PrimaryKey;
import com.lvtinger.database.persistence.metadata.Property;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MetadataResolver {

    public Metadata resolve(Class clazz){
        if (clazz == null) {
            return null;
        }

        Table table = (Table) clazz.getDeclaredAnnotation(Table.class);
        if (table == null) {
            return null;
        }

        Metadata metadata = new Metadata();
        String tableName = StringUtils.isEmpty(table.value()) ? clazz.getSimpleName() : table.value();
        metadata.setName(tableName);

        List<Property> properties = new ArrayList<>();
        metadata.setProperties(properties);

        Field[] fields = ReflectionUtils.getFields(clazz);
        int length = fields.length;
        for (int i = 0; i < length; i++){
            Field field = fields[i];

            if(field.getDeclaredAnnotation(Transient.class) != null){
                continue;
            }

            Column column = field.getDeclaredAnnotation(Column.class);
            Property property = new Property();
            if(column == null || StringUtils.isEmpty(column.value())){
                property.setName(field.getName());
            }
            property.setType(field.getType());
            properties.add(property);

            Id id = field.getDeclaredAnnotation(Id.class);
            if(id != null){
                PrimaryKey primaryKey = new PrimaryKey();
                primaryKey.setName(property.getName());
                metadata.setPrimaryKey(primaryKey);
            }
        }

        return metadata;
    }
}