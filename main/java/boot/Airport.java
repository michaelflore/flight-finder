package boot;

public class Airport {
    private String airport_id;
    private String airport_name;
    private String airport_tags;
    
    public Airport() {
    }
    
    public Airport(String airport_id, String airport_name, String airport_tags) {
        this.airport_id = airport_id;
        this.airport_name = airport_name;
        this.airport_tags = airport_tags;
    }
    
    public String getAirportId() {
        return airport_id;
    }
    
    public String getAirportName() {
        return airport_name;
    }

    public String getAirportTags() {
        return airport_tags;
    }
}
