package combinator_pattern;

import java.time.LocalDate;

import static combinator_pattern.CustomerRegistrationValidator.*;
import static combinator_pattern.CustomerRegistrationValidator.ValidationResult.*;

public class Driver {

    public static void main(String[] args) {
        Customer customer = new Customer(
                "Prahlad Panthi",
                "prahlad1231@gmail.com",
                "9843468335",
                LocalDate.of(1997, 10, 02)
        );

//        System.out.println(new CustomerValidatorService().isValid(customer));

        // using combinator pattern
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);

        System.out.println(result);

        if(result != SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
