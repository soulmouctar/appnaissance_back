package com.dyma.naissanceapi.profiles;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.mockito.Mockito.when;
import static org.springframework.boot.jdbc.EmbeddedDatabaseConnection.H2;
//Ajout des test pour le repository des profils
@DataJpaTest
@AutoConfigureTestDatabase(connection = H2)
public class ProfileRepositoryTest {
    @Autowired
    ProfilesService profilesService;
    @Autowired
    ProfilesRespository profilesRepository;

    @Test
    void setUp(){
        Profile profileOne = Profile.builder().email("one@gmail.com").build();
        Profile profileTwo = Profile.builder().email("two@gmail.com").build();
        when(profilesService.search()).thenReturn(List.of(profileOne,profileTwo));
    }

    @Test
    void shouldReturnListOfProfiles() {
        // Arrange
        Profile profile1 = Profile.builder().email("one@email.com").build();
        Profile profile2 = Profile.builder().email("two@email.com").build();
        profilesRepository.saveAll(List.of(profile1, profile2));

        // Act
        List<Profile> profiles = profilesRepository.findAll();

        // Assert
        Assertions.assertEquals(2, profiles.size());

    }

    @Test
    void search() throws Exception {
//        this.mockMVC
    }

    @Test
    void create() throws JsonProcessingException {
        //Arrange
        Profile profileOne = Profile.builder().email("one@gmail.com").build();
        String profileAsString = new ObjectMapper().writeValueAsString(profileOne);
        //Act / Assert
//        this.Moc
    }
}
