package pl.coderslab.Classes.Reservations;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReservationServiceTest {
    @Mock
    ReservationHandler reservationHandler;
    @Test
    void processReservation_reservationIsValidCanBeProcessed_reservationStatusChandedToConfirmed() {
        ReservationService reservationService = new ReservationService(reservationHandler);
        Reservation reservation = new Reservation();

        when(reservationHandler.canHandleReservation(reservation)).thenReturn(true);

        reservationService.processReservation(reservation);

        assertEquals(ReservationStatus.CONFIRMED,reservation.getReservationStatus());

        verify(reservationHandler,atLeastOnce()).prepare(reservation);
        then(reservationHandler).should().prepare(reservation);

        InOrder inOrder = inOrder(reservationHandler);
        inOrder.verify(reservationHandler).canHandleReservation(reservation);
        inOrder.verify(reservationHandler).prepare(reservation);

    }
}