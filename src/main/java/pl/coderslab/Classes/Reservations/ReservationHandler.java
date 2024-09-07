package pl.coderslab.Classes.Reservations;

public interface ReservationHandler {
    boolean canHandleReservation(Reservation reservation);

    void prepare(Reservation reservation);
}
