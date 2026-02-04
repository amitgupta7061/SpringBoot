package stream;

import java.util.*;
import java.util.stream.*;

public class streamex {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        // ==================== CREATING STREAMS ====================
        System.out.println("=== Creating Streams ===");

        // From Collection
        Stream<Integer> stream1 = numbers.stream();

        // From Array
        String[] arr = { "a", "b", "c" };
        Stream<String> stream2 = Arrays.stream(arr);

        // Using Stream.of()
        Stream<Integer> stream3 = Stream.of(1, 2, 3);

        // Using Stream.iterate()
        Stream<Integer> stream4 = Stream.iterate(0, n -> n + 2).limit(5); // 0, 2, 4, 6, 8

        // Using Stream.generate()
        Stream<Double> stream5 = Stream.generate(Math::random).limit(3);

        // ==================== INTERMEDIATE OPERATIONS ====================
        System.out.println("\n=== Intermediate Operations ===");

        // filter() - Filter elements based on condition
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);

        // map() - Transform each element
        List<Integer> squared = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Squared: " + squared);

        // flatMap() - Flatten nested streams
        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6));
        List<Integer> flat = nested.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("Flattened: " + flat);

        // distinct() - Remove duplicates
        List<Integer> unique = Arrays.asList(1, 2, 2, 3, 3, 3).stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Unique: " + unique);

        // sorted() - Sort elements
        List<Integer> sorted = Arrays.asList(5, 2, 8, 1, 9).stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted: " + sorted);

        // sorted() with comparator - Custom sorting
        List<String> sortedByLength = names.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
        System.out.println("Sorted by length: " + sortedByLength);

        // limit() - Limit number of elements
        List<Integer> firstThree = numbers.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("First 3: " + firstThree);

        // skip() - Skip first n elements
        List<Integer> skipThree = numbers.stream()
                .skip(3)
                .collect(Collectors.toList());
        System.out.println("Skip 3: " + skipThree);

        // peek() - Debug/inspect elements (doesn't modify)
        List<Integer> peeked = numbers.stream()
                .peek(n -> System.out.print("Processing: " + n + " "))
                .filter(n -> n > 5)
                .collect(Collectors.toList());
        System.out.println("\nPeek result: " + peeked);

        // ==================== TERMINAL OPERATIONS ====================
        System.out.println("\n=== Terminal Operations ===");

        // forEach() - Iterate over elements
        System.out.print("forEach: ");
        numbers.stream().limit(5).forEach(n -> System.out.print(n + " "));
        System.out.println();

        // collect() - Collect to collection
        Set<Integer> numberSet = numbers.stream().collect(Collectors.toSet());
        System.out.println("Collected to Set: " + numberSet);

        // toArray() - Convert to array
        Integer[] array = numbers.stream().toArray(Integer[]::new);
        System.out.println("To Array: " + Arrays.toString(array));

        // reduce() - Reduce to single value
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Sum using reduce: " + sum);

        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println("Max using reduce: " + max.orElse(0));

        // count() - Count elements
        long count = numbers.stream().filter(n -> n > 5).count();
        System.out.println("Count > 5: " + count);

        // min() and max() - Find min/max
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);
        Optional<Integer> maximum = numbers.stream().max(Integer::compareTo);
        System.out.println("Min: " + min.orElse(0) + ", Max: " + maximum.orElse(0));

        // findFirst() and findAny()
        Optional<Integer> first = numbers.stream().filter(n -> n > 5).findFirst();
        System.out.println("First > 5: " + first.orElse(0));

        // anyMatch(), allMatch(), noneMatch()
        boolean anyEven = numbers.stream().anyMatch(n -> n % 2 == 0);
        boolean allPositive = numbers.stream().allMatch(n -> n > 0);
        boolean noneNegative = numbers.stream().noneMatch(n -> n < 0);
        System.out.println(
                "Any even: " + anyEven + ", All positive: " + allPositive + ", None negative: " + noneNegative);

        // ==================== COLLECTORS ====================
        System.out.println("\n=== Collectors ===");

        // joining() - Join strings
        String joined = names.stream().collect(Collectors.joining(", "));
        System.out.println("Joined: " + joined);

        // groupingBy() - Group elements
        Map<Integer, List<String>> groupedByLength = names.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by length: " + groupedByLength);

        // partitioningBy() - Partition into two groups
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Partitioned (even/odd): " + partitioned);

        // summarizingInt() - Get statistics
        IntSummaryStatistics stats = numbers.stream()
                .collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println("Stats - Count: " + stats.getCount() + ", Sum: " + stats.getSum() +
                ", Avg: " + stats.getAverage() + ", Min: " + stats.getMin() + ", Max: " + stats.getMax());

        // toMap() - Collect to map
        Map<String, Integer> nameToLength = names.stream()
                .collect(Collectors.toMap(name -> name, String::length));
        System.out.println("Name to length: " + nameToLength);

        // ==================== PRIMITIVE STREAMS ====================
        System.out.println("\n=== Primitive Streams ===");

        // IntStream, LongStream, DoubleStream
        int intSum = IntStream.rangeClosed(1, 10).sum();
        System.out.println("IntStream sum 1-10: " + intSum);

        double avg = IntStream.of(1, 2, 3, 4, 5).average().orElse(0);
        System.out.println("IntStream average: " + avg);

        // mapToInt() - Convert to IntStream
        int totalLength = names.stream().mapToInt(String::length).sum();
        System.out.println("Total length of names: " + totalLength);

        // ==================== PARALLEL STREAMS ====================
        System.out.println("\n=== Parallel Streams ===");

        long parallelSum = numbers.parallelStream()
                .mapToLong(Integer::longValue)
                .sum();
        System.out.println("Parallel sum: " + parallelSum);

        // ==================== OPTIONAL ====================
        System.out.println("\n=== Optional ===");

        Optional<String> optionalName = names.stream()
                .filter(n -> n.startsWith("Z"))
                .findFirst();

        // Using orElse()
        String result = optionalName.orElse("Not found");
        System.out.println("Find name starting with Z: " + result);

        // Using ifPresent()
        names.stream()
                .filter(n -> n.startsWith("A"))
                .findFirst()
                .ifPresent(n -> System.out.println("Found: " + n));
    }
}
