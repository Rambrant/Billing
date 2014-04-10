package com.tradedoubler.testutil;

/**
 * Open Source Class. Copied from
 * http://code.google.com/p/sortpom/source/browse/#svn%2Ftrunk%2Fsrc%2Ftest%2Fjava%2Fsortpom%2Futil
 * Licence: http://opensource.org/licenses/BSD-3-Clause
 */

import java.lang.reflect.Field;
import java.util.*;


class FieldHelper {
    private boolean accessibleState;
    private final Field field;

    public static List<Field> getAllFields(Class<?> type) {
        List<Field> fields = new ArrayList<Field>();
        for (Class<?> c = type; c != null; c = c.getSuperclass()) {
            fields.addAll(Arrays.asList(c.getDeclaredFields()));
        }
        return fields;
    }

    public FieldHelper(Class<?> instanceClass, String fieldName) throws SecurityException,
            NoSuchFieldException {
        Field foundField = null;
        List<Field> allFields = getAllFields(instanceClass);
        for (Field field : allFields) {
            if (field.getName().equals(fieldName)) {
                foundField = field;
            }
        }
        field = foundField;
    }

    public FieldHelper(Class<?> instanceClass, Class<?> valueClass) {
        List<Field> fields = getAllFields(instanceClass);
        List<Field> fieldMatches = new ArrayList<Field>();
        for (Field field : fields) {
            if (field.getType().isAssignableFrom(valueClass)) {
                fieldMatches.add(field);
            }
        }
        if (fieldMatches.size() == 0) {
            throw new IllegalArgumentException(String.format("Cannot find field for %s", valueClass));
        }
        if (fieldMatches.size() != 1) {
            throw new IllegalArgumentException(String.format("Found %s matches for field %s", fieldMatches.size(),
                    valueClass));
        }

        field = fieldMatches.get(0);
    }

    public Field getField() {
        accessibleState = field.isAccessible();
        field.setAccessible(true);
        return field;
    }

    public void restoreAccessibleState() {
        field.setAccessible(accessibleState);
    }

}