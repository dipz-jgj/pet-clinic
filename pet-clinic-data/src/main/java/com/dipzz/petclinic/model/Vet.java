package com.dipzz.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder //produces complex builder APIs for your classes
@Entity
@Table(name = "vets")
public class Vet extends Person{

    // Eager means that JPA is going to try to load everything all at once
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vets_specialties",
        joinColumns = @JoinColumn(name = "vet_id"),
        inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialties = new HashSet<>();
}
