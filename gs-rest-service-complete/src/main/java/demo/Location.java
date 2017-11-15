package demo;

public class Location {

	private final int id;
	private final String name;
    private final double latitude;
    private final double longitude;

    public Location(int id, String name, double latitude, double longitude) {
    	this.id  = id;
    	this.name = name;
    	this.latitude = latitude;
        this.longitude = longitude;
    }

    public Location(String name, double latitude, double longitude) {
    	this.id  = -1;
    	this.name = name;
    	this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public int getID() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public double getLatitude() {
        return this.latitude;
    }
    
    public double getLongitude() {
        return this.longitude;
    }
    
    public String toString(){
    	StringBuilder builder = new StringBuilder();
    	builder.append(this.getName())
    		.append(", ")
    	    .append(this.getLatitude())
    	    .append(", ")
    		.append(this.getLongitude());
    	    
    	return builder.toString();
    }
}