package com.dyma.naissanceapi.profiles;

import com.dyma.naissanceapi.shared.entity.Address;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Table(name = "profiles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private Civility civility = Civility.MR;
    private String firstName;
    private String lastName;
    private String email;
    @Column(unique = true)
    private String phone;
    private String password;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
}
