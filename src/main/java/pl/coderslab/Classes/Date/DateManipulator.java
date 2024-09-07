package pl.coderslab.Classes.Date;

import lombok.RequiredArgsConstructor;

import java.time.Clock;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
@RequiredArgsConstructor
public class DateManipulator {
    private final Clock clock;


    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public LocalDate parseStringToDate(String dateString) {
        return LocalDate.parse(dateString, formatter);
    }

    public String formatDateToString(LocalDate date) {
        return date.format(formatter);
    }

    public LocalDate addDaysToDate(LocalDate date, int daysToAdd) {
        return date.plusDays(daysToAdd);
    }

    public LocalDate subtractDaysFromDate(LocalDate date, int daysToSubtract) {
        return date.minusDays(daysToSubtract);
    }

    public boolean isFutureDate(LocalDate date) {
        return date.isAfter(LocalDate.now(clock));
    }

    public boolean isPastDate(LocalDate date) {
        return date.isBefore(LocalDate.now(clock));
    }
}
