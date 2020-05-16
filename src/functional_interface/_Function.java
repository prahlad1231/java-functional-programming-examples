package functional_interface;

import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int increment = incrementByOne(5);
        System.out.println(increment);
        int result1 = incrementByOne.apply(increment);
        System.out.println(result1);

        int result2 = multiplyBy10.apply(result1);
        System.out.println(result2);

        // Function chaining
        Function<Integer, Integer> chainedFunction = incrementByOne.andThen(multiplyBy10);
        System.out.println(chainedFunction.apply(3));
    }

    static Function<Integer, Integer> incrementByOne = n -> n + 1; // Function<Input, Output>

    static Function<Integer, Integer> multiplyBy10 = n -> n * 10;

    static  int incrementByOne(int n) {
        return n + 1;
    }
}
