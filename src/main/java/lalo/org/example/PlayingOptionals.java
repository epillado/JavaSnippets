package org.example;

import java.util.Optional;

public class PlayingOptionals {

    public static void main(String[] args) {

        /* The Optional class was introduced in Java 8 */

        /*  Conditional value with Optional */

        // Let's create and Optional for an Integer:
        Optional<Integer> optionalInteger = Optional.of(10);

        // We can get the value from the Optional when it is present or a
        // default value when it's not:
        int value0= optionalInteger.isPresent()?optionalInteger.get():0;

        // And the same can be done like this, because Optional.orElse() is
        // like an Optional.Get() that takes a default value:
        int value1= optionalInteger.orElse(0);

        /* Conditional action with Optional. */

        // Let's create and Optional for a String:
        Optional<String> optionalString = Optional.of("Something");

        // We can execute some action when the object is present and another
        // action when it's not.
        optionalString.ifPresentOrElse(System.out::println,
                ()-> System.out.println("Empty"));
        optionalString = Optional.empty();
        optionalString.ifPresentOrElse(System.out::println,
                ()-> System.out.println("Empty"));

        /* I call the next one "Trick or treat": You get a value or an action
         is executed */
        Optional<Integer> receivedCandy = Optional.empty();
        int candy = receivedCandy.orElseGet(()-> {
            System.out.println("Graffiting your fence.");
            return -1;
        });

        /* If you didn't have enough, we'll throw things (exceptions) */
        try {
            candy = receivedCandy.orElseThrow();
        } catch (Exception e) {
            System.out.println("Splat!");;
        }
        
    }

}
