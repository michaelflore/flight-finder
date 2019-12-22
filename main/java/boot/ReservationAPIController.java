package boot;

import java.security.Principal;
import org.slf4j.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

// needed for cross domain Ajax
@CrossOrigin(origins="http://s.codepen.io")
@RestController
public class ReservationAPIController {

    private static final Logger log = LoggerFactory.getLogger(ReservationAPIController.class);

    @Autowired
    ReservationService res;

    @Autowired
    RoleService roleService;

    @RequestMapping(value="/reservation", method=RequestMethod.POST)
    public Reservation createReservation(
        @RequestBody Reservation reservation,
        Principal principal
    ) { 
        String username = principal.getName();
        if (principal != null && username != null ) {
            reservation.username = username;
            res.save(reservation);
        }
        return reservation;
    }

    // End user GET request for their reservations
    @RequestMapping(value="/reservation", method=RequestMethod.GET)
    public Iterable<Reservation> getReservations(Principal principal) {
        return res.getByUsername(principal.getName());
    }

    @RequestMapping(value="/reservation/{reservation_id}", method=RequestMethod.GET)
    public Reservation getReservation(
        @PathVariable("reservation_id") String reservation_id,
        Principal principal
    ) {
        Reservation reservation = res.getById(reservation_id);
        if (reservation != null && reservation.username.equals(principal.getName())) {
            return reservation;
        }
        return null;
    }

    @RequestMapping(value="/reservation/{reservation_id}", method=RequestMethod.DELETE)
    public Reservation deleteReservation(
        @PathVariable("reservation_id") String reservation_id,
        Principal principal
    ) {
        Reservation reservation = res.getById(reservation_id);
        if (reservation != null && reservation.username.equals(principal.getName())) {
            res.delete(reservation);
        } else {
            log.info("A user attempted to delete someone else's reservation.");
        }
        return reservation;
    }

    @RequestMapping(value="/reservation", method=RequestMethod.PUT)
    public Reservation updateReservation(
        @RequestBody Reservation reservation,
        Principal principal
    ) { 
        Reservation r = res.getById(reservation.getReservationId());
        if (r != null && r.username.equals(principal.getName())) {
            res.confirm(reservation);
        }
        return reservation; 
    }

    @RequestMapping(value="/cr/reservation", method=RequestMethod.GET)
    public Iterable<Reservation> searchReservationByCR(
        @RequestParam(value="username", required=false) String username,
        @RequestParam(value="id", required=false) String id
    ) {
        if (id != null) {
            log.info("id: " + id);
            return res.searchById(id);
        }
        if (username != null) {
            log.info("username: " + username);
            return res.searchByUsername(username);
        }

        return null;
    }

    @RequestMapping(value="/admin/reservation", method=RequestMethod.GET)
    public Iterable<Reservation> searchReservationByAdmin(
        @RequestParam(value="username", required=false) String username,
        @RequestParam(value="airline_id", required=false) String airline_id,
        @RequestParam(value="flight_id", required=false) String flight_id,
        @RequestParam(value="departure_date", required=false) String departure_date,
        @RequestParam(value="id", required=false) String id
    ) {
        if (id != null) {
            log.info("id: " + id);
            return res.searchById(id);
        } else if (username != null) {
            log.info("username: " + username);
            return res.searchByUsername(username);
        } else if (airline_id !=null) {
            log.info("airline_id: " + airline_id);
            return res.searchByFlight(airline_id, flight_id, departure_date);
        }
        return null;
    }
 
    @RequestMapping(value="/cr/reservation", method=RequestMethod.POST)
    public Reservation createReservationByCR(@RequestBody Reservation reservation) {
        return res.save(reservation);
    }

    @RequestMapping(value="/cr/reservation", method=RequestMethod.PUT)
    public Reservation updateReservationByCR(@RequestBody Reservation reservation) {
        return res.confirm(reservation);
    }

	@RequestMapping(value="/cr/reservation/{id}", method=RequestMethod.DELETE)
    public Reservation deleteReservationByCR(
        @PathVariable("id") String id, 
        Principal principal
    ) {
        Reservation reservation = res.getById(id);
        if (reservation != null) {
            res.delete(reservation);
        } else {
            log.info("A user attempted to delete someone else's reservation");
        }
        return reservation;
    }
}
