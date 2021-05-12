import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



enum SAVED_PLACE  {
    FILE,
    MEMORY
}

@Target(value= ElementType.METHOD)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface CacheMethod {
    SAVED_PLACE savedPlace();
}
