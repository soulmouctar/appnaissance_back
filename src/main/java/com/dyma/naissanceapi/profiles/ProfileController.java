package com.dyma.naissanceapi.profiles;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/profiles")
public class ProfileController {


    private final ProfilesService profilesService;
    Logger logger = LoggerFactory.getLogger(ProfileController.class);

    public ProfileController(ProfilesService profilesService) {
        this.profilesService = profilesService;
    }

    @PostMapping("/create")
    private void createProfile(@RequestBody Profile profile) {
        logger.info("Creation du compte de : "+ profile.getEmail());
        this.profilesService.create(profile);
    }
}
