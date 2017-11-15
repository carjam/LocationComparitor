package demo;

public class Boundary {
	private final double north;
	private final double south;
	private final double east;
	private final double west;
	
	//Positive latitude is above the equator (N), and negative latitude is below the equator (S).
	//Positive longitude is east of the prime meridian, while negative longitude is west of the prime meridian
	public Boundary(double north, double south, double east, double west)
	{
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
	}

	public double getNorth()
	{
		return north;
	}
	
	public double getSouth()
	{
		return south;
	}
	public double getEast()
	{
		return east;
	}
	public double getWest()
	{
		return west;
	}

	public boolean isPointWithin(double lat, double lng)
	{
		return isLongContained(lng) && isLatContained(lat);
	}
	
	private boolean isLongContained(double lng)
	{
		//-180 is far west, 180 is far east
		boolean longContained;
		
		if((east < 0)&&(west > 0)) //spans Prime Meridian like Alaska
			longContained = (Math.abs(lng) > Math.abs(east)) && (Math.abs(lng) > Math.abs(west));
		else if((east > 0)&&(west < 0)) //spans Pacific 180s
			longContained = (Math.abs(lng) < Math.abs(east)) && (Math.abs(lng) < Math.abs(west));
		else //100% eastern Hem(positive numbers) OR 100% western Hem(negative numbers)
			longContained = (lng < east) && (lng > west);

		return longContained;
	}
	
	private boolean isLatContained(double lat)
	{
		//-90 is far south, 90 is far north
		boolean latContained;
		
		if((north < 0)&&(south > 0)) //spans Prime Meridian like Alaska
			latContained = (Math.abs(lat) > Math.abs(north)) && (Math.abs(lat) > Math.abs(south));
		else if((north > 0)&&(south < 0)) //spans Pacific 180s
			latContained = (Math.abs(lat) < Math.abs(north)) && (Math.abs(lat) < Math.abs(south));
		else //100% eastern Hem(positive numbers) OR 100% western Hem(negative numbers)
			latContained = (lat < north) && (lat > south);
		
		return latContained;
	}
	

}