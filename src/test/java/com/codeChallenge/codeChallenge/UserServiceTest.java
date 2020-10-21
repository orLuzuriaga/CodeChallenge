package com.codeChallenge.codeChallenge;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import com.codeChallenge.codeChallenge.dto.AddressDto;
import com.codeChallenge.codeChallenge.dto.UserDto;
import com.codeChallenge.codeChallenge.service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureTestDatabase
public class UserServiceTest {
    

    private UserDto  userDto;
    private AddressDto addressDto;



    @BeforeEach
    void init()
    {
        addressDto = new AddressDto();
        addressDto.setStreet("Avda Juan de la Cierva");
        addressDto.setCity("Madrid");
        addressDto.setCountry("España");
        addressDto.setState("Parla");

        LocalDate birthDate = LocalDate.of(1986, 03, 21);
        userDto = new UserDto();
        userDto.setName("Juan Lopez");
        userDto.setEmail("juan@gmail.com");
        userDto.setBirthDate(birthDate);
        userDto.setAddress(addressDto);



        

    }

    @Autowired
    private UserService userService;

    @Test
    void getUsers()
    {
        assertTrue(userService.getUsers().size() > 0);
    }


    @Test
    void getUsersEnabled()
    {
        assertTrue(userService.getAllUserEnabled().size() > 0);
    }


    @Test
    void saveUser()
    {
        assertNotNull(userService.getUsers());
        
    }


    @Test
    void updateUser()
    {
        Long id = Long.valueOf(1);
        assertNotNull(userService.updateUser(id, userDto));
    }



    @Test
    void getUser()
    {
        Long id = Long.valueOf(1);
        assertNotNull(userService.getUser(id));
        
    }



    @Test
    void deleteUser()
    {
        Long id = Long.valueOf(1);
        assertNotNull(userService.deleteUserById(id));
    }











}
