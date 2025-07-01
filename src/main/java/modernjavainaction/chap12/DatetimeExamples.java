package modernjavainaction.chap12;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class DatetimeExamples {

    public static void main(String[] args) {

        print("LocalDate 만들고 값 읽기");
        printLocalDate();

        print("TemporalField를 이용해서 LocalDate값 읽기");
        printTemporalField();

        print("LocalTime 만들고 값 읽기");
        printLocalTime();

        print("시간 문자열을 parse하는 메서드");
        printParseDateTime();

        print("LocalDateTime 만들기");
        printLocalDateTime();

        print("Instant 만들기");
        printInstant();

        print("Duration과 Period 만들기");
        printDurationPeriod();

        print("LocalDate의 속성 바꾸기");
        printChangeLocalDate();
    }

    static void printChangeLocalDate() {

        LocalDate date = LocalDate.now();
        System.out.println(date.withYear(2021));
        System.out.println(date.withDayOfMonth(25));
        System.out.println(date.with(ChronoField.MONTH_OF_YEAR, 2));
        System.out.println(date.plusWeeks(1));
        System.out.println(date.minusYears(6));
        System.out.println(date.plus(6, ChronoUnit.MONTHS));
    }

    static void printDurationPeriod() {

        LocalDateTime dateTime1 = LocalDateTime.now();
        LocalDateTime dateTime2 = LocalDateTime.of(2018, 3, 1, 8, 40, 0);
        Duration d1 = Duration.between(dateTime2, dateTime1);
        System.out.println(d1);
        System.out.println(d1.getSeconds());

        Period days = Period.between(LocalDate.of(2018, 3, 1), LocalDate.now());
        System.out.println(days);

        System.out.println(Duration.ofMinutes(3));
        System.out.println(Duration.of(3, ChronoUnit.MINUTES));

        System.out.println(Period.ofDays(10));
        System.out.println(Period.ofWeeks(3));
        System.out.println(Period.of(2, 6, 1));
    }

    static void printInstant() {

        System.out.println(Instant.ofEpochSecond(0));
        System.out.println(Instant.ofEpochSecond(3, 0));
        System.out.println(Instant.ofEpochSecond(2, 1_000_000_000));
        System.out.println(Instant.ofEpochSecond(4, -1_000_000_000));
        System.out.println(Instant.now());
    }

    static void printLocalDateTime() {

        LocalDateTime dt1 = LocalDateTime.of(2025, Month.JULY, 1, 17, 10, 20);
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime dt2 = LocalDateTime.of(localDate, localTime);
        LocalDateTime dt3 = localDate.atTime(17, 11, 0);
        LocalDateTime dt4 = localDate.atTime(localTime);
        LocalDateTime dt5 = localTime.atDate(localDate);

        System.out.println(dt1);
        System.out.println(dt2);
        System.out.println(dt3);
        System.out.println(dt4);
        System.out.println(dt5);
        System.out.println(dt1.toLocalDate());
        System.out.println(dt1.toLocalTime());
    }

    static void printParseDateTime() {
        LocalDate date = LocalDate.parse("2025-07-01");
        LocalTime time = LocalTime.parse("17:07:21");
        System.out.println(date);
        System.out.println(time);
    }

    static void printLocalTime() {
        LocalTime time = LocalTime.of(13, 45, 20);
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());
    }

    static void printTemporalField() {

        LocalDate date = LocalDate.now();
        System.out.println(date.get(ChronoField.YEAR));
        System.out.println(date.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(date.get(ChronoField.DAY_OF_MONTH));
    }

    static void print(String str) {
        System.out.println("\n\n" + str);
    }

    static void printLocalDate() {
        LocalDate date = LocalDate.of(2025, 07, 01);
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dow = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean leap = date.isLeapYear();

        System.out.println(date);
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
        System.out.println(dow);
        System.out.println(len);
        System.out.println(leap);

        System.out.println(LocalDate.now());
    }
}
