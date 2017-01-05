package testing.app.experiment;

import java.io.*;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.function.*;

/**
 * Created by yun.li on 9/30/16.
 */
public class TestNestedClass {

    private static <X, Y> void processElements(
            Iterable<X> source,
            Predicate<X> tester,
            Function <X, Y> mapper,
            Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }
    public static void run () {
        class Person {
            public Person (String n, String e, int a) {
                name = n;
                email = e;
                age = a;
            }
            public String name;
            public String email;
            public int age;
            @Override
            public String toString () {
                return (name + ": Email = " + email + "; age = " + age);
            }
        }

        LinkedList<Person> persons = new LinkedList<> ();
        persons.add(new Person("Lee", "yun.li@live.com", 30));
        persons.add(new Person("Vicky", "vickyz528@gmail.com", 12));

        System.out.println ("Testing Anonymous Class:");
        processElements (
                persons,
                new Predicate<Person> () {
                    @Override
                    public boolean test (Person p) {
                        return p.age >= 20;
                    };
                },
                new Function<Person, String> () {
                    @Override
                    public String apply (Person p) {
                        return p.email;
                    }
                },
                new Consumer<String> () {
                    @Override
                    public void accept (String email) {
                        System.out.println(email);
                    }
                }
        );

        System.out.println ("Testing Lambda Expression:");
        processElements (
                persons,
                p -> p.age >= 20,
                p -> p.toString(),
                str -> System.out.println(str)
        );
    }
}
