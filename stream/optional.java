package stream;

import java.util.Optional;

public class optional {

    public static void main(String[] args) {

        // ==================== CREATING OPTIONAL ====================
        System.out.println("=== Creating Optional ===");

        // Empty Optional
        Optional<String> empty = Optional.empty();
        System.out.println("Empty optional: " + empty);

        // Optional with value
        Optional<String> withValue = Optional.of("Hello");
        System.out.println("With value: " + withValue);

        // Optional with nullable value (can be null)
        String nullableValue = null;
        Optional<String> nullable = Optional.ofNullable(nullableValue);
        System.out.println("Nullable (null): " + nullable);

        Optional<String> nullable2 = Optional.ofNullable("World");
        System.out.println("Nullable (value): " + nullable2);

        // ==================== CHECKING VALUE PRESENCE ====================
        System.out.println("\n=== Checking Value Presence ===");

        Optional<String> name = Optional.of("Alice");
        Optional<String> emptyName = Optional.empty();

        // isPresent() - returns true if value exists
        System.out.println("name.isPresent(): " + name.isPresent());
        System.out.println("emptyName.isPresent(): " + emptyName.isPresent());

        // isEmpty() - returns true if no value (Java 11+)
        System.out.println("emptyName.isEmpty(): " + emptyName.isEmpty());

        // ==================== GETTING VALUES ====================
        System.out.println("\n=== Getting Values ===");

        // get() - throws NoSuchElementException if empty
        System.out.println("name.get(): " + name.get());

        // orElse() - return default if empty
        System.out.println("emptyName.orElse(\"Default\"): " + emptyName.orElse("Default"));

        // orElseGet() - return from supplier if empty (lazy evaluation)
        System.out.println("emptyName.orElseGet(() -> \"Generated\"): " +
                emptyName.orElseGet(() -> "Generated"));

        // orElseThrow() - throw exception if empty
        try {
            emptyName.orElseThrow(() -> new RuntimeException("No value present"));
        } catch (RuntimeException e) {
            System.out.println("orElseThrow caught: " + e.getMessage());
        }

        // ==================== CONDITIONAL ACTIONS ====================
        System.out.println("\n=== Conditional Actions ===");

        // ifPresent() - execute action if value present
        name.ifPresent(n -> System.out.println("ifPresent: Hello, " + n));
        emptyName.ifPresent(n -> System.out.println("This won't print"));

        // ifPresentOrElse() - execute action or else action (Java 9+)
        name.ifPresentOrElse(
                n -> System.out.println("ifPresentOrElse: Found " + n),
                () -> System.out.println("No value"));

        emptyName.ifPresentOrElse(
                n -> System.out.println("Found " + n),
                () -> System.out.println("ifPresentOrElse: No value found"));

        // ==================== TRANSFORMING VALUES ====================
        System.out.println("\n=== Transforming Values ===");

        // map() - transform the value
        Optional<Integer> length = name.map(String::length);
        System.out.println("name.map(length): " + length.orElse(0));

        Optional<String> upper = name.map(String::toUpperCase);
        System.out.println("name.map(toUpperCase): " + upper.orElse(""));

        // flatMap() - for nested Optionals
        Optional<Optional<String>> nested = Optional.of(Optional.of("Nested"));
        Optional<String> flattened = nested.flatMap(o -> o);
        System.out.println("flatMap: " + flattened.orElse(""));

        // Example with method returning Optional
        Optional<String> result = name.flatMap(optional::findNickname);
        System.out.println("flatMap with method: " + result.orElse("No nickname"));

        // ==================== FILTERING ====================
        System.out.println("\n=== Filtering ===");

        // filter() - keep value if matches predicate
        Optional<String> filteredName = name.filter(n -> n.startsWith("A"));
        System.out.println("filter starts with A: " + filteredName.orElse("Not found"));

        Optional<String> filteredName2 = name.filter(n -> n.startsWith("B"));
        System.out.println("filter starts with B: " + filteredName2.orElse("Not found"));

        // ==================== CHAINING OPTIONALS ====================
        System.out.println("\n=== Chaining Optionals ===");

        // or() - return alternative Optional if empty (Java 9+)
        Optional<String> primary = Optional.empty();
        Optional<String> secondary = Optional.of("Backup");
        Optional<String> chosen = primary.or(() -> secondary);
        System.out.println("or(): " + chosen.orElse(""));

        // Chaining multiple operations
        String finalResult = Optional.of("  hello world  ")
                .map(String::trim)
                .map(String::toUpperCase)
                .filter(s -> s.length() > 5)
                .orElse("Too short");
        System.out.println("Chained: " + finalResult);

        // ==================== PRACTICAL EXAMPLES ====================
        System.out.println("\n=== Practical Examples ===");

        // Example 1: Null-safe method chaining
        User user = new User("John", null); // email is null
        String email = Optional.ofNullable(user.getEmail())
                .orElse("no-email@default.com");
        System.out.println("User email: " + email);

        // Example 2: Finding in collection
        Optional<User> foundUser = findUserById(1);
        foundUser.ifPresentOrElse(
                u -> System.out.println("Found user: " + u.getName()),
                () -> System.out.println("User not found"));

        // Example 3: Avoiding null checks
        String city = Optional.ofNullable(user)
                .map(User::getAddress)
                .map(Address::getCity)
                .orElse("Unknown city");
        System.out.println("User city: " + city);
    }

    // Helper method for flatMap example
    static Optional<String> findNickname(String name) {
        if (name.equals("Alice")) {
            return Optional.of("Ali");
        }
        return Optional.empty();
    }

    // Helper method for practical example
    static Optional<User> findUserById(int id) {
        if (id == 1) {
            return Optional.of(new User("John", "john@email.com"));
        }
        return Optional.empty();
    }
}

// Helper classes for practical examples
class User {
    private String name;
    private String email;
    private Address address;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }
}

class Address {
    private String city;

    public String getCity() {
        return city;
    }
}
