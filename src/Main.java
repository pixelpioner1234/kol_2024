import java.time.LocalTime;

public class Main {
    public static void main(String[] args){

        DigitalClock clock24 = new DigitalClock(ClockMode.TWENTY_FOUR_HOUR);
        clock24.setCurrentTime();
        //System.out.println("clock24: " + clock24);

        DigitalClock clock12 = new DigitalClock(ClockMode.TWELVE_HOUR);
        clock12.setTime(14, 30, 0);
        //System.out.println("clock12: " + clock12);





        City lublin = new City("Lublin", "+1", 51.2465, 22.5684);
        LocalTime timeZoneTime = LocalTime.of(12, 0, 0);
        LocalTime localMeanTime = lublin.localMeanTime(timeZoneTime);
        System.out.println("Lokalny czas średni w Lublinie: " + localMeanTime);





    }
}
