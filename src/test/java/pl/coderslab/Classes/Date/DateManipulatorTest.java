package pl.coderslab.Classes.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.*;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DateManipulatorTest {
    @BeforeEach
            void setUp(){
        dateManipulator = new DateManipulator(clock);
    }
    DateManipulator dateManipulator;

    @Mock
    Clock clock;

    @Test
    void parseStringToDate() {
        String dateString = "2024-05-23";
        LocalDate localDate = LocalDate.of(2024,5,23);

        assertEquals(localDate,dateManipulator.parseStringToDate(dateString));

    }

    @Test
    void formatDateToString() {
        String dateString = "2024-05-23";
        LocalDate localDate = LocalDate.of(2024,5,23);


        assertEquals(dateString,dateManipulator.formatDateToString(localDate));
    }

    @Test
    void addDaysToDate() {
        LocalDate localDate = LocalDate.of(2024,5,23);
        LocalDate changedDate = localDate.plusDays(5);

        LocalDate result = dateManipulator.addDaysToDate(localDate,5);

        assertEquals(changedDate,result);
    }

    @Test
    void subtractDaysFromDate_returnsCorrectDate() {
        LocalDate localDate = LocalDate.of(2024,5,23);
        LocalDate changedDate = localDate.minusDays(5);

        LocalDate result = dateManipulator.subtractDaysFromDate(localDate,5);

        assertEquals(changedDate,result);
    }

    @Test
    void isFutureDate_whenChecked_returnsProperBoolan() {
        LocalDate localDate = LocalDate.of(2024,05,24);
        LocalDate futureDate = LocalDate.of(2025,06,26);
        LocalDate pastDate = LocalDate.of(2023,04,22);

        Instant instant = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();

        when(clock.instant()).thenReturn(instant);
        when(clock.getZone()).thenReturn(ZoneId.systemDefault());

        assertTrue(dateManipulator.isFutureDate(futureDate));
        assertFalse(dateManipulator.isFutureDate(pastDate));
    }

    @Test
    void isPastDate() {
        LocalDate localDate = LocalDate.of(2024,05,24);
        LocalDate futureDate = LocalDate.of(2025,06,26);
        LocalDate pastDate = LocalDate.of(2023,04,22);

        Instant instant = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();

        when(clock.instant()).thenReturn(instant);
        when(clock.getZone()).thenReturn(ZoneId.systemDefault());

        assertTrue(dateManipulator.isPastDate(pastDate));
        assertFalse(dateManipulator.isPastDate(futureDate));

    }
}