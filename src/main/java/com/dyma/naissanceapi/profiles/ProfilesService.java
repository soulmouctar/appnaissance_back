package com.dyma.naissanceapi.profiles;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ProfilesService {
    private final ProfilesRespository profilesRespository;

    public void  create(Profile profile) {
        log.info("Nouveau compte crée avec l'email :  {}",  profile.getEmail());
        profilesRespository.save(profile);
    }

    public List<Profile> search() {
        return this.profilesRespository.findAll();
    }

    public Profile read(int id) {
        Optional<Profile> profile = this.profilesRespository.findById(id);
        return profile.orElse(null);
    }

}
