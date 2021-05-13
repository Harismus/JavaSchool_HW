package myannotation;

import java.awt.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



import enums.cacheType;


@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface CacheMethod {
    cacheType savedPlace() default cacheType.MEMORY;
    boolean isZip() default false;
    String fileNamePrefix() default "data";
    Class[] identityBy() default{String.class, double.class};

}

