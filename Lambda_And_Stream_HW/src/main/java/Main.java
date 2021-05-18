import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;


public class Main {




    public static void main(String[] args) {


        List<Person> someCollection = new ArrayList<>();

        someCollection.add( new Person( "Alex", 13 ) );
        someCollection.add( new Person( "Vasja",14 ) );
        someCollection.add( new Person( "Kostja",15 ) );
        someCollection.add( new Person( "Petja",18 ) );
        someCollection.add( new Person( "Roma",22 ) );
        someCollection.add( new Person( "Katja",26 ) );


        Map<String, Person> m = Streams.<Person>of(someCollection)
                .filter(p -> p.getAge() > 20)
                .transform( p -> new Person(p.getName(),p.getAge() + 30))
                .toMap(p -> p.getName(), p -> p);



        m.forEach( (k, p) -> System.out.println(p.toString() +  " Name = " + p.getName() + " Age = " + p.getAge() ) );
    }
}
