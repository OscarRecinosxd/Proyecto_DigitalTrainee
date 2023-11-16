package com.bookinghotels.booking_hotels_api.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "roles")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
    @SequenceGenerator(name = "role_seq",sequenceName = "role_seq",allocationSize = 1)
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "userRole")
    private List<User> users;
}