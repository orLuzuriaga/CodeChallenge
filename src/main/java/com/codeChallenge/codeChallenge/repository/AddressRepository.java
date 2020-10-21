package com.codeChallenge.codeChallenge.repository;

import com.codeChallenge.codeChallenge.entity.Address;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long>{
    
}
