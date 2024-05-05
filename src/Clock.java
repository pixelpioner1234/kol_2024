import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class Clock {
    public LocalTime currentTime;
    private City city;
    public int currentHour;

    public Clock(City city) {
        this.city = city;
    }
    protected Clock() {}

    public int getCurrentHour() {
        return (int) (Math.random() * 24);
    }
    public void setCurrentHour(int hour) {
        this.currentHour = hour;
    }
    public void setCurrentTime() {
        currentTime = LocalTime.now();
    }

    public void setTime(int hour, int minute, int second) {
        if (hour<0 || hour>=24 || minute<0 || minute>=60 || second<0 || second>=60){
            throw new IllegalArgumentException("Niepoprawne dane czasu.");
        }
        currentTime = LocalTime.of(hour, minute, second);
    }



    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        return currentTime.format(formatter);
    }



    public void setCity(City newCity) {
        City oldCity = this.city;
        this.city = newCity;

        int oldTimeZone = Integer.parseInt(oldCity.getTimeZone());
        int newTimeZone = Integer.parseInt(newCity.getTimeZone());
        int timeDifference = newTimeZone - oldTimeZone;

        int currentHour = getCurrentHour();
        int newHour = (currentHour + timeDifference) % 24;

        setCurrentHour(newHour);
    }

}
