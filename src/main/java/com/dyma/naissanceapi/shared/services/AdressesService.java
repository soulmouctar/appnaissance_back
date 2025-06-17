package com.dyma.naissanceapi.shared.services;

import com.dyma.naissanceapi.shared.entity.Address;
import com.dyma.naissanceapi.shared.repository.AdressesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AdressesService {

    private AdressesRepository adressesRepository;
    public Address create(Address address) {
        return this.adressesRepository.save(address);
    }
}
