package boot;

import java.util.*;
import java.security.Principal;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

// needed for cross domain Ajax
@CrossOrigin(origins="http://s.codepen.io")
@RestController
public class AppUserAPIController {

    // private static final Logger log = LoggerFactory.getLogger(AppUserAPIController.class);

    @Autowired
    AppUserService aus;

    @Autowired
    RoleService rs;

    @RequestMapping(value="/user", method=RequestMethod.GET)
    public AppUser getAppUser(Principal principal) {
        AppUser user = new AppUser();
        if (principal != null) {
            String username = principal.getName();
            user = new AppUser(username, null);
            ArrayList<String> roles = new ArrayList<String>(); // This is important, some users may have multiple roles
            
            for(Role r: rs.getRoles(username)) {
                roles.add(r.getRole());
            }

            user.setRoles(roles);
        }

        return user;
    }

    // Having AppUser as input will make Spring do the following
    // 1. create a AppUser object and 
    // 2. map client input to object attribute with same name
	@RequestMapping(value="/user", method=RequestMethod.POST)
    public AppUser createAppUser(@RequestBody AppUser auser) {
    	return aus.save(auser);
    }

    @RequestMapping(value="/admin/user/{username}", method=RequestMethod.GET)
    public AppUser getAppUser(@PathVariable("username") String username) {
        return aus.get(username);
    }

	@RequestMapping(value="/admin/user", method=RequestMethod.POST)
    public AppUser addAppUserByAdmin(@RequestBody AppUser auser) {
        aus.upsert(auser);
        rs.delete(auser.getUsername());
        for(String s: auser.getRoles()) {
            rs.save(new Role(auser.getUsername(), s));
        }
        return auser;
    }

    @RequestMapping(value="/admin/user", method=RequestMethod.PUT)
    public AppUser updateAppUserByAmin(@RequestBody AppUser auser) {
        return aus.update(auser);
    }

    @RequestMapping(value="/admin/user", method=RequestMethod.DELETE)
    public AppUser deleteAppUserByAdmin(@RequestBody AppUser auser) {
        aus.delete(auser);
        return new AppUser();
    }

    // This should be role gated, only admins can have access to 
	@RequestMapping(value="/admin/user", method=RequestMethod.GET)
    public Iterable<AppUser> searchAppUsers(
    	@RequestParam(value="name", required=false) String[] names) {
        // name=val1&name=val2 passed as an array
        Iterable<AppUser> users = aus.searchAppUsers(names);
        for(AppUser u:users) {
            ArrayList<String> roles = new ArrayList<String>();
            for(Role r: rs.getRoles(u.getUsername())) {
                roles.add(r.getRole());
            }
            u.setRoles(roles);
        }
        return users;
    }
}
