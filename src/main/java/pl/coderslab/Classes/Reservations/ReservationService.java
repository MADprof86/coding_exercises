package pl.coderslab.Classes.Reservations;

public class ReservationService {

    private final ReservationHandler reservationHandler;

    public ReservationService(ReservationHandler reservationHandler) {
        this.reservationHandler = reservationHandler;
    }

    public Reservation processReservation(Reservation reservation) {
        if (reservationHandler.canHandleReservation(reservation)) {
            reservationHandler.prepare(reservation);
            reservation.setStatus(ReservationStatus.CONFIRMED);
        } else {
            reservation.setStatus(ReservationStatus.REJECTED);
        }
        return reservation;
    }
}
