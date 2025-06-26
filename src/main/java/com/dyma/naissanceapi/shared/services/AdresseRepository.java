package com.dyma.naissanceapi.shared.services;

import com.dyma.naissanceapi.shared.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresseRepository extends JpaRepository<Address, Integer> {
    // This interface will automatically provide CRUD operations for Address entities
    // No additional methods are needed unless specific queries are required
}
