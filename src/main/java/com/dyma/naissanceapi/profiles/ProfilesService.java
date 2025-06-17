package com.dyma.naissanceapi.profiles;

import com.dyma.naissanceapi.shared.entity.Address;
import com.dyma.naissanceapi.shared.repository.AdressesRepository;
import com.dyma.naissanceapi.shared.services.AdressesService;
import com.dyma.naissanceapi.shared.services.ValidationsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ProfilesService {
    private final AdressesService adressesService;
    private final ProfilesRespository profilesRespository;
    private final ValidationsService validationsService;

    public void  create(Profile profile) {
        log.info("Nouveau compte crée avec l'email :  {}",  profile.getEmail());
        if(profile.getAddress() != null) {
            Address address = this.adressesService.create(profile.getAddress());
            profile.setAddress(address);
        }
        validationsService.validateEmail(profile.getEmail());
        validationsService.validatePhone(profile.getPhone());
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
