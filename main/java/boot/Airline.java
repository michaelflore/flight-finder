package boot;

public class Airline {
    private String airline_id;
    private String airline_name;
    
    public Airline() {}
    
    public Airline(String airline_id, String airline_name) {
        this.airline_id = airline_id;
        this.airline_name = airline_name;
    }
    
    public String getAirlineId() {
        return this.airline_id;
    }
    
    public String getAirlineName() {
        return this.airline_name;
    }
}
