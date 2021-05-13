package myannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import enums.SAVED_PLACE;


@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface CacheMethod {
    SAVED_PLACE savedPlace() default SAVED_PLACE.MEMORY;
    boolean isZip() default false;

}
