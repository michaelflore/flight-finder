package boot;

public class Aircraft {
    private String aircraft_id;
    private String aircraft_model;
    private String airline_id;
    private int economy_class_seats;
    private int business_class_seats;
    private int first_class_seats;
    
    public Aircraft() {}
    
    public Aircraft(String aircraft_id, String aircraft_model, String airline_id) {
        this.aircraft_id = aircraft_id;
        this.aircraft_model = aircraft_model;
        this.airline_id = airline_id;
    }
    
    public String getAircraftId() {
        return this.aircraft_id;
    }
    
    public String getAircraftModel() {
        return this.aircraft_model;
    }
    
    public String getAirlineId() {
        return this.airline_id;
    }

    public int getEconomyClassSeats() {
        return this.economy_class_seats;
    }

    public int getBusinessClassSeats() {
        return this.business_class_seats;
    }

    public int getFirstClassSeats() {
        return this.first_class_seats;
    }

    public void setEconomyClassSeats(int seats) {
        this.economy_class_seats = seats;
    }

    public void setBusinessClassSeats(int seats) {
        this.business_class_seats = seats;
    }

    public void setFirstClassSeats(int seats) {
        this.first_class_seats = seats;
    }
}
