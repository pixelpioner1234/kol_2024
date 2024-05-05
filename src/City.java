import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class City {

    public String name;
    public String timeZone;
    public double latitude;
    public double longitude;

    public String getName() {
        return name;
    }
    public String getTimeZone() {
        return timeZone;
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public City(String name, String timeZone, double latitude, double longitude) {
        this.name = name;
        this.timeZone = timeZone;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    private static City parseLine(String line){
        String[] parts = line.split(", ");

        String name = parts[0];
        String timeZone = parts[1];
        double latitude = Double.parseDouble(parts[2].split(" ")[0]);
        double longitude = Double.parseDouble(parts[3].split(" ")[0]);

        return new City(name, timeZone, latitude, longitude);
    }


    public static Map<String, City> parseFile(String filePath){
        Map<String, City> cityMap = new HashMap<>();

        try {
            Files.lines(Paths.get(filePath))
                    .map(City::parseLine)
                    .forEach(city -> cityMap.put(city.getName(), city));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cityMap;
    }


    public LocalTime localMeanTime(LocalTime time) {
        double hourOffset = longitude / 15.0;
        int minuteOffset = (int) (hourOffset * 60);

        return time.plusMinutes(minuteOffset);
    }


    public static Comparator<City> worstTimezoneFit() {





    }

}
