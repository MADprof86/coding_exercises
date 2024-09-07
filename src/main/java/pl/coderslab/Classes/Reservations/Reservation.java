package pl.coderslab.Classes.Reservations;

import lombok.Getter;

@Getter
public class Reservation {
    private ReservationStatus reservationStatus;

    public void setStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }




}
