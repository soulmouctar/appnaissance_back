package com.dyma.naissanceapi.profiles;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
        return profile.orElseThrow(()-> new EntityNotFoundException( " " +
                "Profile not found with id: " + id));
    }


    public Profile update(int id, Profile profile) {
        Profile profileInDataBase =  this.read(id);
        profileInDataBase.setEmail(profile.getEmail());
        profileInDataBase.setFirstName(profile.getFirstName());
        profileInDataBase.setLastName(profile.getLastName());
        profileInDataBase.setPhone(profile.getPhone());
        profileInDataBase.setPassword(profile.getPassword());
        profileInDataBase = this.profilesRespository.save(profileInDataBase);
        return profileInDataBase;
    }

    public void delete(int id) {
        Profile profile = this.read(id);
        profilesRespository.delete(profile);
    }
}
