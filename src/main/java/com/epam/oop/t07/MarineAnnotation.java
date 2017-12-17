package com.epam.oop.t07;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MarineAnnotation {
    int someValue() default 42;
    String author() default "No name presented";
}
