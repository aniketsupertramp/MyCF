package utils;

public class TimeUtils {

    private long sinceTime;
    private long untilTime;

    public long getSinceTime() {
        return sinceTime;
    }

    public void setSinceTime(long sinceTime) {
        this.sinceTime = sinceTime;
    }

    public long getUntilTime() {
        return untilTime;
    }

    public void setUntilTime(long untilTime) {
        this.untilTime = untilTime;
    }

    public TimeUtils(long sinceTime, long untilTime) {
        this.sinceTime = sinceTime;
        this.untilTime = untilTime;
    }



}
