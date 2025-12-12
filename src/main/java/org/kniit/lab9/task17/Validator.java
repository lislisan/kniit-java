package org.kniit.lab9.task17;

import java.lang.reflect.Field;

public class Validator {
    public static void validate(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(obj);

            if (field.isAnnotationPresent(NotNull.class) && value == null) {
                System.out.println("Поле " + field.getName() + " не должно быть null.");
            }

            if (field.isAnnotationPresent(MaxLength.class) && value != null) {
                MaxLength maxLengthAnnotation = field.getAnnotation(MaxLength.class);
                int maxLength = maxLengthAnnotation.value();

                if (value instanceof String) {
                    String strValue = (String) value;
                    if (strValue.length() > maxLength) {
                        System.out.println("Поле " + field.getName() + " превышает максимальную длину " + maxLength + ".");
                    }
                }
                else {
                    System.out.println("Всё хорошо");
                }
            }

            if (field.isAnnotationPresent(Min.class)) {
                Min minAnnotation = field.getAnnotation(Min.class);
                int minValue = minAnnotation.value();

                if (value instanceof Integer) {
                    int intValue = (int) value;
                    if (intValue < minValue) {
                        System.out.println("Поле " + field.getName() +
                                " должно быть не меньше " + minValue + ".");
                    }
                } else if (value != null) {
                    try {
                        Number numberValue = (Number) value;
                        if (numberValue.intValue() < minValue) {
                            System.out.println("Поле " + field.getName() +
                                    " должно быть не меньше " + minValue + ".");
                        }
                    } catch (ClassCastException e) {
                        System.out.println("Поле " + field.getName() +
                                " имеет нечисловой тип для аннотации @Min.");
                    }
                }
                else {
                    System.out.println("Всё хорошо");
                }
            }
        }
    }
}