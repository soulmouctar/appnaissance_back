package com.dyma.naissanceapi.shared.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ValidationsServiceTest {
    @InjectMocks
    ValidationsService validationsService;

    @Test
    void shoulTestThatEmailIsValid() {
        //(Arrange) definir les variables
        String email = "test@email.com";

        //(Act) appeler la méthode à tester
        this.validationsService.validateEmail(email);

        //(Assert) vérifier le résultat

    }

    @Test
    void shouldThrowExceptionWhenEmailIsInvalid () {
        // Arrange
        String email = null;

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            this.validationsService.validateEmail(email);
        });

        // Assert
        assertEquals(exception.getMessage(), "Email cannot be null or empty");
    }

    @Test
    void validatePhone() {
    }
}