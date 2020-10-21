package com.codeChallenge.codeChallenge;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;


import com.codeChallenge.codeChallenge.entity.Address;
import com.codeChallenge.codeChallenge.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;



@AutoConfigureMockMvc
@SpringBootTest
public class RestControllerTest {


    @Autowired
    private MockMvc mockMvc;



    @Autowired
    ObjectMapper objectmapper;


 
    
    


    @Test
    void getAllUsers()throws Exception 
    {
        String uri = "/getusers";
        RequestBuilder request = MockMvcRequestBuilders.get(uri);
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());
    }



    @Test
    void getAllUsersEnabled()throws Exception 
    {
        String uri = "/getusersenabled";
        RequestBuilder request = MockMvcRequestBuilders.get(uri);
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());
    }



    @Test
    void createUser()throws Exception{
        
        Long id = Long.valueOf(1);
        LocalDate birthdate = LocalDate.now();
        String uri ="/createUsers";
        Address newAddress = new Address(id,"Calle 25 de Mayo", "Madrid", "Madrid", "España", "28911");
        User newUser = new User(id,"Juan Lopez", "juan@gmail.com",birthdate,newAddress,true);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
        .contentType(MediaType.APPLICATION_JSON_VALUE).content(objectmapper.writeValueAsString(newUser))).andReturn();
        assertEquals(201, mvcResult.getResponse().getStatus());

    }



    @Test
    void getUserById() throws Exception
    {
        String uri = "/getusersById/1";

        RequestBuilder request = MockMvcRequestBuilders.get(uri);
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());


    }

    @Test
    void updateUser()throws Exception{

        Long id = Long.valueOf(1);
        LocalDate birthdate = LocalDate.now();
        String uri ="/updateUsersById/1";
        Address newAddress = new Address(id,"Calle 25 de Mayo", "Madrid", "Madrid", "España", "28911");
        User user = new User(id,"Juan Lopez", "juan@gmail.com",birthdate,newAddress,true);


        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put(uri, user)
        .contentType(MediaType.APPLICATION_JSON_VALUE).content(objectmapper.writeValueAsString(user))).andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());

    }



    

    @Test
    void deleteUser()throws Exception{

        Long id = Long.valueOf(1);
        LocalDate birthdate = LocalDate.now();
        String uri ="/deleteUsersById/1";
        Address newAddress = new Address(id,"Calle 25 de Mayo", "Madrid", "Madrid", "España", "28911");
        User user = new User(id,"Juan Lopez", "juan@gmail.com",birthdate,newAddress,true);


        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(uri)
        .contentType(MediaType.APPLICATION_JSON_VALUE).content(objectmapper.writeValueAsString(user))).andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());

    }






}
