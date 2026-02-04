
/**
 * 23_DateAndTime.java - Date, Time, LocalDate, LocalDateTime
 */

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

class DateAndTime {
    public static void main(String[] args) {
        // === LocalDate (Date only) ===
        System.out.println("=== LocalDate ===");
        LocalDate today = LocalDate.now();
        LocalDate specific = LocalDate.of(2024, 12, 25);
        LocalDate parsed = LocalDate.parse("2024-06-15");

        System.out.println("Today: " + today);
        System.out.println("Year: " + today.getYear());
        System.out.println("Month: " + today.getMonth());
        System.out.println("Day: " + today.getDayOfMonth());
        System.out.println("Day of week: " + today.getDayOfWeek());

        // === LocalTime (Time only) ===
        System.out.println("\n=== LocalTime ===");
        LocalTime now = LocalTime.now();
        LocalTime specific2 = LocalTime.of(14, 30, 45);

        System.out.println("Now: " + now);
        System.out.println("Hour: " + now.getHour());
        System.out.println("Minute: " + now.getMinute());

        // === LocalDateTime (Date + Time) ===
        System.out.println("\n=== LocalDateTime ===");
        LocalDateTime dateTime = LocalDateTime.now();
        LocalDateTime specific3 = LocalDateTime.of(2024, 12, 25, 10, 30, 0);

        System.out.println("DateTime: " + dateTime);

        // === Date Manipulation ===
        System.out.println("\n=== Manipulation ===");
        LocalDate tomorrow = today.plusDays(1);
        LocalDate lastWeek = today.minusWeeks(1);
        LocalDate nextMonth = today.plusMonths(1);

        System.out.println("Tomorrow: " + tomorrow);
        System.out.println("Last week: " + lastWeek);

        // === Formatting ===
        System.out.println("\n=== Formatting ===");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatted = today.format(formatter);
        System.out.println("Formatted: " + formatted);

        DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("DateTime: " + dateTime.format(dtFormatter));

        // Parse with format
        LocalDate parsedFormatted = LocalDate.parse("25/12/2024", formatter);
        System.out.println("Parsed: " + parsedFormatted);

        // === Comparison ===
        System.out.println("\n=== Comparison ===");
        LocalDate date1 = LocalDate.of(2024, 1, 1);
        LocalDate date2 = LocalDate.of(2024, 12, 31);

        System.out.println("isBefore: " + date1.isBefore(date2));
        System.out.println("isAfter: " + date2.isAfter(date1));
        System.out.println("isEqual: " + date1.isEqual(date1));

        // === Period and Duration ===
        System.out.println("\n=== Period & Duration ===");
        Period period = Period.between(date1, date2);
        System.out.println("Period: " + period.getMonths() + " months, " + period.getDays() + " days");

        long daysBetween = ChronoUnit.DAYS.between(date1, date2);
        System.out.println("Days between: " + daysBetween);

        // === ZonedDateTime ===
        System.out.println("\n=== ZonedDateTime ===");
        ZonedDateTime zdt = ZonedDateTime.now();
        ZonedDateTime tokyo = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("Local: " + zdt);
        System.out.println("Tokyo: " + tokyo);

        // === Instant (Timestamp) ===
        Instant instant = Instant.now();
        System.out.println("Epoch millis: " + instant.toEpochMilli());
    }
}
