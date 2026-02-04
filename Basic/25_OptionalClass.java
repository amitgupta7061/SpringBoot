
/**
 * 25_OptionalClass.java - Handling Null Values with Optional
 */

import java.util.Optional;

class OptionalClass {
    public static void main(String[] args) {
        // === Creating Optional ===
        Optional<String> opt1 = Optional.of("Hello"); // Non-null value
        Optional<String> opt2 = Optional.empty(); // Empty optional
        Optional<String> opt3 = Optional.ofNullable(null); // May be null

        // === Checking Value ===
        System.out.println("isPresent: " + opt1.isPresent()); // true
        System.out.println("isEmpty: " + opt2.isEmpty()); // true (Java 11+)

        // === Getting Value ===
        // get() - throws exception if empty
        System.out.println("Value: " + opt1.get());

        // orElse() - provide default
        String value = opt2.orElse("Default");
        System.out.println("With default: " + value);

        // orElseGet() - lazy default (lambda)
        String lazy = opt2.orElseGet(() -> "Computed Default");
        System.out.println("Lazy default: " + lazy);

        // orElseThrow() - throw if empty
        try {
            opt2.orElseThrow(() -> new RuntimeException("No value!"));
        } catch (RuntimeException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // === Conditional Actions ===
        // ifPresent() - execute if value exists
        opt1.ifPresent(v -> System.out.println("Has value: " + v));

        // ifPresentOrElse() - Java 9+
        opt2.ifPresentOrElse(
                v -> System.out.println("Value: " + v),
                () -> System.out.println("No value present"));

        // === Transformations ===
        // map() - transform value
        Optional<Integer> length = opt1.map(String::length);
        System.out.println("Length: " + length.orElse(0));

        // flatMap() - for nested optionals
        Optional<String> nested = Optional.of("text");
        Optional<String> upper = nested.flatMap(s -> Optional.of(s.toUpperCase()));
        System.out.println("Upper: " + upper.get());

        // filter() - conditional
        Optional<String> filtered = opt1.filter(s -> s.length() > 3);
        System.out.println("Filtered: " + filtered.orElse("Too short"));

        // === Practical Example ===
        User user = new User("Alice");
        String email = Optional.ofNullable(user.getEmail())
                .orElse("no-email@default.com");
        System.out.println("Email: " + email);

        // Chaining
        String result = Optional.ofNullable(user)
                .map(User::getName)
                .map(String::toUpperCase)
                .orElse("UNKNOWN");
        System.out.println("Name: " + result);
    }
}

class User {
    private String name;
    private String email;

    User(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }
}
