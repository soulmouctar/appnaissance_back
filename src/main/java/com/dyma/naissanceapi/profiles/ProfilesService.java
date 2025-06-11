package com.dyma.naissanceapi.profiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProfilesService {
    Logger logger = LoggerFactory.getLogger(ProfilesService.class);
    public void create(Profile profile) {
        logger.info("Nouveau compte crée avec l'email :  {}",  profile.getEmail());
    }
}
