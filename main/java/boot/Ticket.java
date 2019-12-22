package boot;

import java.util.Date;

public class Ticket {
    private String ticket_id;
    private String reservation_id;
    private String leg_id;
    private String airline_id;
    private String flight_id;
    private String departure_weekday;
    private String departure_date;
    private String price;
    private String waitlist_status;

    public Ticket(
        String ticket_id, 
        String reservation_id, 
        String leg_id, 
        String airline_id, 
        String flight_id, 
        String departure_weekday, 
        String departure_date, 
        String price, 
        String waitlist_status
    ){
        this.ticket_id = ticket_id;
        this.reservation_id = reservation_id;
        this.leg_id = leg_id;
        this.airline_id = airline_id;
        this.flight_id = flight_id;
        this.departure_weekday = departure_weekday;
        this.departure_date = departure_date;
        this.price = price;
        this.waitlist_status = waitlist_status;
    }

    public String getTicketId(){ return this.ticket_id; }

    public String getReservationId(){ return this.reservation_id; }

    public String getLegId(){ return this.leg_id; }

    public String getAirlineId(){ return this.airline_id; }

    public String getFlightId(){ return this.flight_id; }

    public String getDepartureWeekday(){ return this.departure_weekday; }

    public String getDepartureDate(){ return this.departure_date; }

    public String getPrice(){ return this.price; }

    public String getWaitlistStatus(){ return this.waitlist_status; }



}
