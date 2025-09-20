package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.convertor.WelcomeMessageService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(ResourceConstants.ROOM_RESERVATION_V1)
public class WelcomeMessage {

    private WelcomeMessageService welcomeMessageService;

    public WelcomeMessage(WelcomeMessageService welcomeMessageService) {
        this.welcomeMessageService = welcomeMessageService;
    }

    @RequestMapping(path ="/welcomeMessage", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<String> getWelcomeMessages() {
        return this.welcomeMessageService.getWelcomeMessages();
    }
}
