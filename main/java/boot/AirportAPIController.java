package boot;

import java.security.Principal;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

// Needed for cross domain Ajax
@CrossOrigin(origins="http://s.codepen.io")
@RestController
public class AirportAPIController {

    // private static final Logger log = LoggerFactory.getLogger(AirportAPIController.class);

    @Autowired
    AirportService as;

    @RequestMapping(value="/airport", method=RequestMethod.GET)
    public Iterable<Airport> get(Principal principal) {
        return as.get();
    }

	@RequestMapping(value="/cr/airport", method=RequestMethod.POST)
    public Airport create(@RequestBody Airport a) {
    	return as.upsert(a);
    }

	@RequestMapping(value="/cr/airport", method=RequestMethod.PUT)
    public Airport update(@RequestBody Airport a) {
        return as.upsert(a);
    }

    @RequestMapping(value="/cr/airport", method=RequestMethod.DELETE)
    public Airport delete(@RequestBody Airport a) {
        as.delete(a);
        return new Airport();
    }
}
