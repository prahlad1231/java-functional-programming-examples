package functional_interface;

import java.util.function.BiFunction;

public class _BiFunction {

    public static void main(String[] args) {
        System.out.println(incrementByOneAndMultiply(2, 10));
        System.out.println(incrementByOneAndMultiply.apply(2, 10));
    }

    // normal method
    static int incrementByOneAndMultiply(int num, int toMultiply) {
        return (num + 1) * toMultiply;
    }

    // bifunction -> takes two inputs and returns one output
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiply =
            (num, toMultiply) -> (num + 1) * toMultiply;

}
