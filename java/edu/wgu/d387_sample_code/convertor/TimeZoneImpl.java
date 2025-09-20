package edu.wgu.d387_sample_code.convertor;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Service
public class TimeZoneImpl implements TimeZoneService {
        ZoneId est = ZoneId.of("America/New_York");
        ZoneId mt = ZoneId.of("America/Denver");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");

        @Override
        public ArrayList<String> getTimes() {
            ArrayList<String> dates = new ArrayList<>();

            ZonedDateTime zonedDateTime = LocalDateTime.now().atZone(ZoneId.systemDefault());
            ZonedDateTime estTime = zonedDateTime.withZoneSameInstant(est).from(zonedDateTime);
            ZonedDateTime mtTime = zonedDateTime.withZoneSameInstant(mt).from(zonedDateTime);
            ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);

            dates.add("Eastern Time: " + estTime.format(format));
            dates.add("Mountain Time: " + mtTime.format(format));
            dates.add("Universal Time: " + utc.format(format));

            return dates;
        };
}
