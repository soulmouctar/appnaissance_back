package com.dyma.naissanceapi.profiles;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)

public class ProfileRepositoryTest {
    @Autowired
    private ProfilesRespository profilesRepository;

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
}
