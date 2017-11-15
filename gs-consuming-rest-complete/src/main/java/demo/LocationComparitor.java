package demo;

public class LocationComparitor {
	public static boolean isInUSA(double lat, double lng)
	{
		return  isIn48USA(lat, lng) || isInHawaii(lat, lng) || isInAlaska(lat, lng);
	}
	
	public static double distanceFromTokyo(double lat, double lng)
	{
		return distanceBetweenPoints(35.6895, 139.69171, lat, lng);
	}
	
	public static double distanceFromSydney(double lat, double lng)
	{
		return distanceBetweenPoints(-33.86785, 151.20732, lat, lng);
	}
	
	public static double distanceFromRiyadh(double lat, double lng)
	{
		return distanceBetweenPoints(24.68773, 46.72185, lat, lng);
	}
	
	public static double distanceFromZurich(double lat, double lng)
	{
		return distanceBetweenPoints(47.36667, 8.55, lat, lng);
	}
	
	public static double distanceFromReykjavik(double lat, double lng)
	{
		return distanceBetweenPoints(64.13548, -21.89541, lat, lng);
	}
	
	public static double distanceFromMexicoCity(double lat, double lng)
	{
		return distanceBetweenPoints(19.42847, -99.12766, lat, lng);
	}
	
	public static double distanceFromLima(double lat, double lng)
	{
		return distanceBetweenPoints(-12.04318, -77.02824, lat, lng);
	}
	
	
	
	private static boolean isIn48USA(double lat, double lng)
	{
		Boundary fortyEight = new Boundary(49.384472f, 24.520833f, -66.947028f, -124.771694f);
		return fortyEight.isPointWithin(lat, lng);
	}
	
	private static boolean isInHawaii(double lat, double lng)
	{
		Boundary hawaii = new Boundary(28.416667f, 18.910833f, -154.811f, -178.333333f);
		return hawaii.isPointWithin(lat, lng);
	}
	
	private static boolean isInAlaska(double lat, double lng)
	{
		Boundary alaska = new Boundary(71.387f, 51.2148f, -129.974194f, 172.443056f);
		return alaska.isPointWithin(lat, lng);
	}
	
	private static double distanceBetweenPoints(double lat1, double lng1, double lat2, double lng2) 
	{
		double earthRadius = 3958.75; // miles (or 6371.0 kilometers)
		double dLat = Math.toRadians(lat2-lat1);
		double dLng = Math.toRadians(lng2-lng1);
		double sindLat = Math.sin(dLat / 2);
		double sindLng = Math.sin(dLng / 2);
		double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
			* Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double dist = earthRadius * c;

		return dist;
	}
}