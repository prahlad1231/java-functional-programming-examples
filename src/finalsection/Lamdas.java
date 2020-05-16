package finalsection;

import java.util.function.Function;

public class Lamdas {
    public static void main(String[] args) {
        Function<String, String> upperCaseName = String::toUpperCase;
        System.out.println(upperCaseName.apply("prahLAD"));
    }
}
