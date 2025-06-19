package com.dyma.naissanceapi.shared.services;

import org.springframework.stereotype.Component;

@Component
public class ValidationsService  {

    public void validateEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new RuntimeException( "Email cannot be null or empty");
        }
        if (email.indexOf('@') == -1 || email.indexOf('@') == email.length()) {
            throw new IllegalArgumentException("Email est invalide ");
        }
        if (!email.matches("^[\\w-\\.]+@[\\w-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email format: " + email);
        }
    }

    public void validatePhone(String phone) {
        if (phone == null) {
            throw new RuntimeException( "Phone number cannot be null ");
        }
        if (phone.length() > 20) {
            throw new IllegalArgumentException(" Phone number is invalid ");
        }
    }

}
