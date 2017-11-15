package demo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LocationController {
	protected final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
    private LocationRepository locations;
    
	@RequestMapping(method={RequestMethod.POST}, value="/location")
    public void addData(@RequestParam(required=true, value="name") String name
    		, @RequestParam(required=true, value="latitude") String latitude
    		, @RequestParam(required=true, value="longitude") String longitude) {
		log.debug("writeLocation with name = " + name + " lat=" + latitude.toString() + " lng=" +longitude);

    	Location loc = new Location(name, Double.parseDouble(latitude), Double.parseDouble(longitude));
    	locations.addLocation(loc);
    }
	
	@RequestMapping(method={RequestMethod.GET}, value="/location", params={"latitude", "longitude"})
    public List<Location> getData(@RequestParam(value="latitude") String latitude
    		, @RequestParam(value="longitude") String longitude) {
		log.debug("location with lat=" + latitude.toString() + " lng=" +longitude);

		ArrayList<Location> list = new ArrayList<Location>();
		if((!empty(latitude))&&(!empty(longitude)))
			list.add(locations.getLocation(Double.parseDouble(latitude), Double.parseDouble(longitude)));
			
		return list;
    }
	
	@RequestMapping(method={RequestMethod.GET}, value="/location")
    public List<Location> getAllDataSets() {

		return locations.getAllLocations();
	}
    
    private boolean empty( final String s ) {
    	  // Null-safe, short-circuit evaluation.
    	  return s == null || s.trim().isEmpty();
    	}
}
