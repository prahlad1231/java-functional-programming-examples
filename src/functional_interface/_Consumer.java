package functional_interface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {
        Customer prahlad = new Customer("Prahlad Panthi", "9843468335");
        greetCustomer(prahlad);

        // functional interface
        greetCustomer.accept(prahlad);
        // biconsumer
        greetConsumerV2.accept(prahlad, false);
        greetConsumerV2.accept(prahlad, true);
    }

    // consumer -> takes one input and doesn't return anything
    static Consumer<Customer> greetCustomer = customer ->
            System.out.println("Hello " + customer.customerName + ", thanks " +
                    "for registering phone number: " + customer.customerPhoneNumber + "\n");

    // biconsumer -> takes two parameters
    static BiConsumer<Customer, Boolean> greetConsumerV2 = ((customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.customerName + ", thanks " +
                    "for registering phone number : " +
                    (showPhoneNumber ? customer.customerPhoneNumber : "**********")));

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName + ", thanks " +
                "for registering phone number: " + customer.customerPhoneNumber + "\n");
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
