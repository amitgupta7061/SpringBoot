/**
 * 21_Enums.java - Enumeration Types
 */

class Enums {
    public static void main(String[] args) {
        // === Basic Enum Usage ===
        Day today = Day.MONDAY;
        System.out.println("Today: " + today);

        // Switch with enum
        switch (today) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY:
                System.out.println("Weekday");
                break;
            case SATURDAY, SUNDAY:
                System.out.println("Weekend");
                break;
        }

        // === Enum Methods ===
        System.out.println("Name: " + today.name());
        System.out.println("Ordinal: " + today.ordinal()); // Position (0-based)

        // Get all values
        System.out.print("All days: ");
        for (Day d : Day.values()) {
            System.out.print(d + " ");
        }
        System.out.println();

        // String to enum
        Day day = Day.valueOf("FRIDAY");
        System.out.println("Parsed: " + day);

        // === Enum with Fields and Methods ===
        Status status = Status.ACTIVE;
        System.out.println(status + " code: " + status.getCode());
        System.out.println(status.getDescription());

        // === Enum with Abstract Method ===
        System.out.println("ADD: " + Operation.ADD.apply(5, 3));
        System.out.println("MULTIPLY: " + Operation.MULTIPLY.apply(5, 3));

        // === Comparing Enums ===
        Day d1 = Day.MONDAY;
        Day d2 = Day.MONDAY;
        System.out.println("d1 == d2: " + (d1 == d2)); // true (use ==, not equals)
        System.out.println("compareTo: " + Day.FRIDAY.compareTo(Day.MONDAY));
    }
}

// Basic enum
enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

// Enum with fields and constructor
enum Status {
    ACTIVE(1, "Currently active"),
    INACTIVE(0, "Not active"),
    PENDING(2, "Waiting for approval");

    private final int code;
    private final String description;

    Status(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}

// Enum with abstract method
enum Operation {
    ADD {
        @Override
        public int apply(int a, int b) {
            return a + b;
        }
    },
    SUBTRACT {
        @Override
        public int apply(int a, int b) {
            return a - b;
        }
    },
    MULTIPLY {
        @Override
        public int apply(int a, int b) {
            return a * b;
        }
    };

    public abstract int apply(int a, int b);
}
