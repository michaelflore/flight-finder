package boot;

import org.slf4j.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service 
public class AircraftService{
    @Autowired
    private JdbcTemplate jdbc;
    
    private static final Logger log = LoggerFactory.getLogger(AircraftService.class);
    
    // Basic save method
    public Aircraft save(Aircraft aircraft) {
        jdbc.update("INSERT INTO aircraft (aicraft_id, aircraft_model, airline_id) VALUES (?, ?, ?)", 
            aircraft.getAircraftId(), 
            aircraft.getAircraftModel(), 
            aircraft.getAirlineId() // arguments
        );
        return aircraft;
    }
    
    // Combine update and save methods for simplifcation
    public Aircraft upsert(Aircraft aircraft) {
        jdbc.update("INSERT INTO aircraft (aircraft_id, airline_id, aircraft_model) "
                  + "VALUES(?, ?, ?) ON DUPLICATE KEY UPDATE "
                  + "aircraft_id=?, aircraft_model=?, airline_id=?", 
            aircraft.getAircraftId(), aircraft.getAirlineId(), aircraft.getAircraftModel(), // arguments
            aircraft.getAircraftId(), aircraft.getAirlineId(), aircraft.getAircraftModel()
        );
        return aircraft;
    }
    
    // Basic delete method
    public void delete(Aircraft aircraft) {
      jdbc.update("DELETE FROM aircraft WHERE aircraft_id=?", aircraft.getAircraftId());
      jdbc.update("DELETE FROM aircraft_capacity WHERE aircraft_id=?", aircraft.getAircraftId());
    }

    // Retrieve all aircraft records from db
    public Iterable<Aircraft> getAircrafts() {
        return jdbc.query("SELECT aircraft_id, airline_id, aircraft_model FROM aircraft",
            new Object[] { }, // pass in args as an array
            (rs, rowNum) -> new Aircraft(rs.getString("aircraft_id"), rs.getString("airline_id"), rs.getString("aircraft_model")));
    }
}
