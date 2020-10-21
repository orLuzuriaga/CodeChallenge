package com.codeChallenge.codeChallenge.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data  
@AllArgsConstructor
@NoArgsConstructor
public class User  {

    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @Column(nullable = false)
    private String name;

    
    private String email;

    
    @Column(name ="BIRTHDATE")
    private LocalDate  birthDate;

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;
    private Boolean enabled;





   
}
