package demo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "name,latitude,longitude,InUSA,MilesFromTK,MilesFromSYD,MilesFromRIY,MilesFromZUR,MilesFromREY,MilesFromMEX,MilesFromLMA";

    public static void writeCsvFile(String fileName, List<Location> locations) {
        FileWriter fileWriter = null;
                 
        try {
            fileWriter = new FileWriter(fileName);

            fileWriter.append(FILE_HEADER.toString());
            fileWriter.append(NEW_LINE_SEPARATOR);

            for (Location loc : locations) {
            	double distanceFromTokyo = LocationComparitor.distanceFromTokyo(loc.getLatitude(), loc.getLongitude());
    			double distanceFromSydney = LocationComparitor.distanceFromSydney(loc.getLatitude(), loc.getLongitude());
    			double distanceFromRiyadh = LocationComparitor.distanceFromRiyadh(loc.getLatitude(), loc.getLongitude());
    			double distanceFromZurich = LocationComparitor.distanceFromZurich(loc.getLatitude(), loc.getLongitude());
    			double distanceFromReykjavik = LocationComparitor.distanceFromReykjavik(loc.getLatitude(), loc.getLongitude());
    			double distanceFromMexicoCity = LocationComparitor.distanceFromMexicoCity(loc.getLatitude(), loc.getLongitude());
    			double distanceFromLima = LocationComparitor.distanceFromLima(loc.getLatitude(), loc.getLongitude());
    			boolean bInUSA = LocationComparitor.isInUSA(loc.getLatitude(), loc.getLongitude());

                fileWriter.append(loc.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(Double.toString(loc.getLatitude()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(Double.toString(loc.getLongitude()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(bInUSA ? "Y" : "N");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(Double.toString(distanceFromTokyo));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(Double.toString(distanceFromSydney));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(Double.toString(distanceFromRiyadh));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(Double.toString(distanceFromZurich));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(Double.toString(distanceFromReykjavik));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(Double.toString(distanceFromMexicoCity));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(Double.toString(distanceFromLima));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("CSV file was created successfully");
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter");
                e.printStackTrace();
            }
        }
    }
}
