package org.example;

import java.util.ArrayList;
import java.util.List;

public class FileFormatter<T> {
    private final Class<T> targetClass;

    public FileFormatter(Class<T> targetClass) {
        this.targetClass = targetClass;
    }

    public String inFileView(List<T> list) {
        List<String> strings = list.stream().map(String::valueOf).toList();
        return String.join(" ", strings);
    }

    public List<T> fromFileView(String content) {
        var tokens = content.split(" ");
        List<T> result = new ArrayList<>(tokens.length);

        for (var token : tokens) {
            T data = converter(token, targetClass);
            result.add(data);
        }

        return result;
    }

    private T converter(String value, Class<T> targetClass) {
        if (targetClass == Integer.class) return (T) Integer.valueOf(value);
        if (targetClass == Boolean.class) return (T) Boolean.valueOf(value);
        if (targetClass == Double.class)  return (T) Double.valueOf(value);
        if (targetClass == Long.class)    return (T) Long.valueOf(value);
        if (targetClass == String.class)  return (T) value;

        throw new IllegalArgumentException();
    }
}
