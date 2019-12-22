package boot;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

// Needed for cross domain Ajax
@CrossOrigin(origins="http://s.codepen.io")
@RestController
public class AircraftAPIController {

    // private static final Logger log = LoggerFactory.getLogger(AircraftAPIController.class);

    @Autowired
    AircraftService as;

    // Calls on capacity service to determine aircraft capacities
    @Autowired
    CapacityService cs;

	@RequestMapping(value="/aircraft", method=RequestMethod.GET)
    public Iterable<Aircraft> getAircrafts() {
        Iterable<Aircraft> aircrafts = as.getAircrafts();
        for(Aircraft a:aircrafts) {
            for(Capacity c: cs.getCapacities(a)) {
                if (c.getSeatClass().equals("economy")) a.setEconomyClassSeats(c.getCapacity());
                if (c.getSeatClass().equals("business")) a.setBusinessClassSeats(c.getCapacity());
                if (c.getSeatClass().equals("first")) a.setFirstClassSeats(c.getCapacity());        
            }
        }
        return aircrafts;
    }

    // Role-based create and delete methods
    // Role gating is done via Application.java
    @RequestMapping(value="/cr/aircraft", method=RequestMethod.POST)
    public Aircraft create(@RequestBody Aircraft aircraft) {
        cs.upsert(new Capacity(aircraft.getAircraftId(), "economy", aircraft.getEconomyClassSeats()));
        cs.upsert(new Capacity(aircraft.getAircraftId(), "business", aircraft.getBusinessClassSeats()));
        cs.upsert(new Capacity(aircraft.getAircraftId(), "first", aircraft.getFirstClassSeats()));
        return as.upsert(aircraft);
    }

    @RequestMapping(value="/cr/aircraft", method=RequestMethod.DELETE)
    public Aircraft delete(@RequestBody Aircraft aircraft) {
        as.delete(aircraft);
        return new Aircraft();
    }
}
