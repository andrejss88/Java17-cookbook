package datetime;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class CurrentTimeMain {

    /**
     * machine-based timestamp from the system
     *
     */
    public static void main(String[] args) {

        // 1) simplest
        System.out.println(Instant.now());      // UTC time, because it uses UTC time-zone
        System.out.println(LocalDateTime.now());

        // 3) of whatever ZoneID you want
        System.out.println("=========");
        System.out.println(LocalDateTime.now(ZoneId.of("America/New_York")));

        var now = LocalDateTime.now();
        System.out.println(now.getMinute());
        System.out.println(now.getHour());
        System.out.println(now.getMonth());

        //and isbefore and other methods that you already seen
    }
}
