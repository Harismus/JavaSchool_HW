import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Streams<T> {

    private List<T> list;

    Streams(List<T> list) {
        this.list = list;
    }

    public static <T> Streams<T> of(List<T> list) {

        return new Streams<T>( list );
    }

    public Streams<T> filter(Predicate<? super T> predicate) {
        List<T> temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            T t = list.get( i );
            if (predicate.test( t )) {
                temp.add( t );
            }
        }

        return new Streams<T>( temp );
    }

    public Streams<T> transform(UnaryOperator<T> unaryOperator) {

        List<T> temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            T t = list.get( i );

            temp.add( unaryOperator.apply( t ) );
        }

        return new Streams<T>( temp );
    }

    public<key> Map<key, T> toMap(Function<T, key> Key, UnaryOperator<T> Value) {

        Map<key, T> map = new HashMap();

        for (int i = 0; i < list.size(); i++) {
            T t = list.get( i );
            map.put( Key.apply( t ), Value.apply( t ));
        }
        return map;
    }
}
