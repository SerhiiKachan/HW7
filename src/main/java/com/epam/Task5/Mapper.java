package com.epam.Task5;

import com.epam.annotation.ForeignKey;
import com.epam.annotation.PrimaryKey;
import com.epam.annotation.SimpleAttribute;
import com.epam.annotation.Table;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class Mapper<T> {

    private static final Logger LOG = Logger.getLogger(Mapper.class);

    private void setValue(Object object, String fieldName, Object value) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(object, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public List<T> executeMapping(ResultSet rs, Class cl) {
        List<T> objectList = new ArrayList<>();
        try {
            if (rs != null) {
                if (cl.isAnnotationPresent(Table.class)) {
                    Field[] fields = cl.getDeclaredFields();
                    T object;
                    while (rs.next()) {
                        ResultSetMetaData rsmd = rs.getMetaData();
                        object = (T) cl.newInstance();
                        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                            String columnName = rsmd.getColumnName(i);
                            Object value = rs.getObject(i);
                            for (Field field : fields) {
                                if (field.isAnnotationPresent(PrimaryKey.class)) {
                                    PrimaryKey primaryKey = field.getAnnotation(PrimaryKey.class);
                                    if (primaryKey.name().equalsIgnoreCase(columnName) && value != null) {
                                        setValue(object, field.getName(), value);
                                        break;
                                    }
                                }
                                if (field.isAnnotationPresent(ForeignKey.class)) {
                                    ForeignKey foreignKey = field.getAnnotation(ForeignKey.class);
                                    if (foreignKey.name().equalsIgnoreCase(columnName) && value != null) {
                                        setValue(object, field.getName(), value);
                                        break;
                                    }
                                }
                                if (field.isAnnotationPresent(SimpleAttribute.class)) {
                                    SimpleAttribute simpleAttribute = field.getAnnotation(SimpleAttribute.class);
                                    if (simpleAttribute.name().equalsIgnoreCase(columnName) && value != null) {
                                        setValue(object, field.getName(), value);
                                        break;
                                    }
                                }
                            }
                        }
                        objectList.add(object);
                    }
                } else
                    LOG.info("It's not a table");
            } else
                return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objectList;
    }
}
