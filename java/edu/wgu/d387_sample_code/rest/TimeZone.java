package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.convertor.TimeZoneService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(ResourceConstants.ROOM_RESERVATION_V1)
public class TimeZone {
    private TimeZoneService timeZoneService;

    public TimeZone(TimeZoneService timeZoneService) {
        this.timeZoneService = timeZoneService;
    }

    @RequestMapping(path ="/timeZones", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<String> getTimeZones() {
        return this.timeZoneService.getTimes();
    }
}
