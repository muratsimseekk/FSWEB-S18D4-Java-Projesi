package com.workintechs18d4project.S18D4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "address",schema = "fsweb")
public class Address {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "no")
    private Long no;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "description" , nullable = false)
    private String description;

    @OneToOne(mappedBy = "address",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Customer customer;

}
