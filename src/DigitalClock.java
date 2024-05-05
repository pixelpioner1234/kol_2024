public class DigitalClock extends Clock{

    public ClockMode mode;

    public DigitalClock(ClockMode mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        if (mode == ClockMode.TWENTY_FOUR_HOUR) {
            return super.toString();
        } else {
            int hour = currentTime.getHour();
            String suffix = (hour < 12) ? "AM" : "PM";
            hour = (hour == 0 || hour == 12) ? 12 : hour % 12;

            //12
            return String.format("%d:%02d:%02d %s", hour, currentTime.getMinute(), currentTime.getSecond(), suffix);
        }
    }
}
