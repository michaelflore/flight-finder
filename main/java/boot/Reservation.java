package boot;

public class Reservation {
    String reservation_id;
    String username;
    String origin_airport_id;
    String purchase_date;
    String purchase_time;
    String departure_date;
    String departure_time;
    String total_fare;
    String fee;
    String special_meal;
    String seat_class;
    String booking_status;

    public Reservation() {
    }

    public Reservation(
        String reservation_id, 
        String username, 
        String origin_airport_id, 
        String purchase_date, 
        String purchase_time, 
        String departure_date, 
        String departure_time, 
        String total_fare,
        String fee, 
        String special_meal,
        String seat_class,
        String booking_status
    ) {
        this.reservation_id = reservation_id;
        this.username = username;
        this.origin_airport_id = origin_airport_id;
        this.purchase_date = purchase_date;
        this.purchase_time = purchase_time;
        this.departure_date = departure_date;
        this.departure_time = departure_time;
        this.total_fare = total_fare;
        this.fee = fee;
        this.special_meal = special_meal;
        this.seat_class = seat_class;
        this.booking_status = booking_status;
    }

    public String getReservationId() { return this.reservation_id; }

    public String getUsername() { return this.username; }

    public String getOriginAirportId() { return this.origin_airport_id; }

    public String getPurchaseDate(){ return this.purchase_date; }

    public String getPurchaseTime(){ return this.purchase_time; }

    public String getDepartureDate(){ return this.departure_date; }

    public String getDepartureTime(){ return this.departure_time; }

    public String getTotalFare(){ return this.total_fare; }

    public String getFee(){ return this.fee; }

    public String getSpecialMeal(){ return this.special_meal; }

    public String getSeatClass(){ return this.seat_class; }

    public String getBookingStatus(){ return this.booking_status; }
}
