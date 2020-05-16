package functional_interface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

// predicate represents boolean valued function of one argument
public class _Predicate {

    public static void main(String[] args) {
        System.out.println("Without using predicate");
        System.out.println(isPhoneNumberValid("986475"));
        System.out.println(isPhoneNumberValid("9843468335"));
        System.out.println(isPhoneNumberValid("435454354"));

        // using predicate
        System.out.println("Using predicate");
        System.out.println(isPhoneNumberValid.test("986475"));
        System.out.println(isPhoneNumberValid.test("9843468335"));
        System.out.println(isPhoneNumberValid.test("435454354"));

        // using chains in predicate
        System.out.println("Using chains in predicates");
        System.out.println(isPhoneNumberValid.and(containsNumber3).test("9843468335"));
        System.out.println(isPhoneNumberValid.and(containsNumber3).test("9841410706"));

        System.out.println(isSame.test("Prahlad", "Prahlad"));
        System.out.println(isSame.test("Prahlad", "Pranav"));
    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("9") && phoneNumber.length() == 10;
    }

    static Predicate<String> isPhoneNumberValid = phoneNumber ->
            phoneNumber.startsWith("9") && phoneNumber.length() == 10;

    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");

    static BiPredicate<String, String> isSame = (name1, name2) ->
            name1.equals(name2);
}
