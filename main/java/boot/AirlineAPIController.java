package boot;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

// Needed for cross domain Ajax
@CrossOrigin(origins="http://s.codepen.io")
@RestController
public class AirlineAPIController {

    // private static final Logger log = LoggerFactory.getLogger(AirlineAPIController.class);

    @Autowired
    AirlineService as;
  
      @RequestMapping(value="/airline", method=RequestMethod.GET)
    public Iterable<Airline> getAirlines() {
      return as.getAirlines();
    }
  
      @RequestMapping(value="/cr/airline", method=RequestMethod.POST)
      public Airline create(@RequestBody Airline airline) {
          return as.upsert(airline);
      }
    @RequestMapping(value="/cr/airline", method=RequestMethod.DELETE)
    public Airline delete(@RequestBody Airline airline) {
        as.delete(airline);
        return new Airline();
    }
  }
