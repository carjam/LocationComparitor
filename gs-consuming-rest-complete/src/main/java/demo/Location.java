package demo;

public class Location {

	private int id;
	private String name;
    private double latitude;
    private double longitude;

    public Location() {
    }
    
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
    
    public void setLongitude(float lng) {
        this.longitude = lng;
    }
    
    public void setID(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setLatitude(double lat) {
        this.latitude = lat;
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