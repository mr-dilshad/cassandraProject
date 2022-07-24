package com.example.cassandra.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;
import java.util.Set;
import java.util.UUID;


@Table
@Builder
@Getter
public class Vet {

    public Vet(UUID id, String firstName, String lastName, Set<String> specialities) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialities = specialities;
    }

    @PrimaryKey
    private UUID id;
    private String firstName;
    private String lastName;
    private Set<String> specialities;

}
