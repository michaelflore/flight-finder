package boot;

public class Flight {
    private String flight_id;
    private String airline_id;
    private String departure_airport_id;
    private String arrival_airport_id;
    private String departure_weekday;
    private String arrival_weekday;
    private String departure_time;
    private String arrival_time;
    private String aircraft_id;
    private String price;

    public Flight() {}

    public Flight(
        String flight_id,
        String airline_id,
        String departure_airport_id,
        String arrival_airport_id,
        String departure_weekday,
        String arrival_weekday,
        String departure_time,
        String arrival_time,
        String aircraft_id,
        String price  
  ) {
        this.flight_id = flight_id;
        this.airline_id = airline_id;
        this.departure_airport_id = departure_airport_id;
        this.arrival_airport_id = arrival_airport_id;
        this.departure_weekday = departure_weekday;
        this.arrival_weekday = arrival_weekday;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
        this.aircraft_id = aircraft_id;
        this.price = price;
  }

  // getter needed for JSON
  public String getFlightId() {
        return this.flight_id;
  }

  public String getAirlineId() {
        return this.airline_id;
  }

  public String getDepartureAirportId() {
        return this.departure_airport_id;
  }

  public String getArrivalAirportId() {
        return this.arrival_airport_id;
  }

  public String getDepartureWeekday() {
        return this.departure_weekday;
  }

  public String getArrivalWeekday() {
        return this.arrival_weekday;
  }

  public String getDepartureTime() {
        return this.departure_time;
  }

  public String getArrivalTime() {
        return this.arrival_time;
  }

  public String getAircraftId() {
        return this.aircraft_id;
  }

  public String getPrice() {
        return this.price;
  }
}