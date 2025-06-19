package com.dyma.naissanceapi.profiles;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProfilesServiceTest {

    @Mock
    ProfilesRespository profilesRespository;

    @InjectMocks
    ProfilesService profilesService;

    @Test
    void shoulReturnAllProfiles() {
        // Arrange
        when(this.profilesRespository.findAll()).thenReturn(
                List.of(
                        Profile.builder()
                                .email("test@test.com")
                                .lastName("Test")
                                .firstName("Unknown")
                                .build()
                )
        );
        // Act
        List<Profile>  profile = profilesService.search();

        // Assert
        assertEquals(1, profile.size());

    }
}