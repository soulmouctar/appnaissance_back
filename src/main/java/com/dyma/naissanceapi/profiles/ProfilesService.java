package com.dyma.naissanceapi.profiles;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ProfilesService {
    private final ProfilesRespository profilesRespository;

    public void  create(Profile profile) {
        log.info("Nouveau compte crée avec l'email :  {}",  profile.getEmail());
        profilesRespository.save(profile);
    } 
}
