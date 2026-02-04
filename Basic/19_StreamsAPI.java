
/**
 * 19_StreamsAPI.java - Stream Operations for Collections
 */

import java.util.*;
import java.util.stream.*;

class StreamsAPI {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // === Creating Streams ===
        Stream<String> stream1 = names.stream();
        Stream<Integer> stream2 = Stream.of(1, 2, 3);
        IntStream range = IntStream.range(1, 5); // 1, 2, 3, 4

        // === Filter ===
        List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Evens: " + evens);

        // === Map (Transform) ===
        List<Integer> doubled = numbers.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
        System.out.println("Doubled: " + doubled);

        List<Integer> lengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("Lengths: " + lengths);

        // === Sorted ===
        List<String> sorted = names.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted: " + sorted);

        // === Reduce ===
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Sum: " + sum);

        // === Count, Min, Max ===
        long count = numbers.stream().filter(n -> n > 5).count();
        Optional<Integer> max = numbers.stream().max(Integer::compare);
        Optional<Integer> min = numbers.stream().min(Integer::compare);
        System.out.println("Count>5: " + count + ", Max: " + max.get());

        // === forEach ===
        System.out.print("forEach: ");
        numbers.stream().forEach(n -> System.out.print(n + " "));
        System.out.println();

        // === anyMatch, allMatch, noneMatch ===
        boolean hasEven = numbers.stream().anyMatch(n -> n % 2 == 0);
        boolean allPositive = numbers.stream().allMatch(n -> n > 0);
        System.out.println("Has even: " + hasEven + ", All positive: " + allPositive);

        // === findFirst, findAny ===
        Optional<Integer> first = numbers.stream().filter(n -> n > 5).findFirst();
        first.ifPresent(n -> System.out.println("First > 5: " + n));

        // === distinct, limit, skip ===
        List<Integer> dups = Arrays.asList(1, 2, 2, 3, 3, 3);
        List<Integer> unique = dups.stream().distinct().collect(Collectors.toList());
        List<Integer> limited = numbers.stream().limit(3).collect(Collectors.toList());
        List<Integer> skipped = numbers.stream().skip(7).collect(Collectors.toList());
        System.out.println("Distinct: " + unique);
        System.out.println("First 3: " + limited);
        System.out.println("Skip 7: " + skipped);

        // === flatMap ===
        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(1, 2), Arrays.asList(3, 4));
        List<Integer> flat = nested.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("Flattened: " + flat);

        // === Collectors ===
        String joined = names.stream().collect(Collectors.joining(", "));
        System.out.println("Joined: " + joined);

        Map<Integer, List<String>> grouped = names.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by length: " + grouped);

        // === Parallel Stream ===
        long parallelSum = numbers.parallelStream()
                .filter(n -> n > 2)
                .mapToLong(n -> n)
                .sum();
        System.out.println("Parallel sum: " + parallelSum);
    }
}
