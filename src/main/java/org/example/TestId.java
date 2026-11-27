package org.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // SOURCE - В .class файл не попадает. CLASS - недоступна через рефлексию.
@Target(ElementType.METHOD)
public @interface TestId {
    String value();
    int order();
}
