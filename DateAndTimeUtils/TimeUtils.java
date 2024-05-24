package dateAndTimeUtils;

import java.util.Date;

public class TimeUtils {

    public static long getTimeInSeconds() {
        return new Date().getTime() / 1000;
    }

    public static void printTotalTimeTaken(long startTime){
        long endTime = TimeUtils.getTimeInSeconds();
        long timeTaken = endTime-startTime;
        System.out.println("Total "+timeTaken+" sec");
    }
}
