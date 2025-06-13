package com.dyma.naissanceapi.profiles;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/profiles")
@AllArgsConstructor
public class ProfileController {

    private final ProfilesService profilesService;

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createProfile(@RequestBody Profile profile) {
        log.info("Creation du compte de : "+ profile.getEmail());
        this.profilesService.create(profile);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Profile> searchProfiles() {
        return this.profilesService.search();
    }

    @GetMapping(path = "{id}")
    public Profile read(@PathVariable int id) {
        return this.profilesService.read(id);

    }

    @PutMapping("{id}")
    public Profile update(@PathVariable int id, @RequestBody Profile profile) {
        return this.profilesService.update(id,profile);
    }

}
