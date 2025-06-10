package com.dyma.naissanceapi.profiles;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@Slf4j
@RestController
@RequestMapping("/profiles")
public class ProfileController {

    Logger logger = Logger.getLogger(ProfileController.class.getName());
    @PostMapping("/create")
    private void createProfile(@RequestBody Profile profile) {
        logger.info("Creation du code "+ profile.getFirstName() + " " + profile.getLastName());
        logger.info(profile.toString());
        logger.warning(profile.toString());
    }
}
