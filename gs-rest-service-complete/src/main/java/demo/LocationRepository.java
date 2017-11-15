package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LocationRepository {
	
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addLocation(Location loc){
        return jdbcTemplate.update("INSERT INTO locations(name, lat, lng) VALUES(?,?,?)", loc.getName(), loc.getLatitude(), loc.getLongitude());
      }
    
    public Location getLocation(double lat, double lng){
	    return jdbcTemplate.queryForObject("SELECT id, name, lat, lng FROM locations WHERE lat = ? AND lng = ?", new Object[] { lat, lng },  new RowMapper<Location>()
	    {

	      public Location mapRow(ResultSet rs, int arg1) throws SQLException {
	        Location l = new Location(
	        		rs.getInt("id")
	        		, rs.getString("name")
	        		, rs.getFloat("lat")
	        		, rs.getFloat("lng")
	        	);
	        
	        return l;
	      }
	    });
	  }

    public List<Location> getAllLocations(){
        return jdbcTemplate.query("SELECT id, name, lat, lng FROM locations", new RowMapper<Location>(){

          public Location mapRow(ResultSet rs, int arg1) throws SQLException {
            Location l = new Location(
            		rs.getInt("id")
            		, rs.getString("name")
            		, rs.getDouble("lat")
            		, rs.getDouble("lng")
            	);
            
            return l;
          }
        });
      }
} 