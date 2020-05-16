package optionals;

import java.util.Optional;

public class Demo {

    public static void main(String[] args) {
        Optional.ofNullable("Pranav")
                .ifPresentOrElse(name -> System.out.println("Hello, " + name + "!"),
                        () -> {
                            System.out.println("Error: No name detected!");
                        });
    }
}
