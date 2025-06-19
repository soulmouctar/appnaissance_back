package com.dyma.naissanceapi.profiles;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ProfilesServiceTest {

    @Mock
    ProfilesRespository profilesRespository;

    @InjectMocks
    ProfilesService profilesService;

    @Test
    void shoulReturnAllProfiles() {
        // Arrange

        // Act
        List<Profile>  profile = profilesService.search();

        // Assert
        assertEquals(true, profile.isEmpty());

    }
}