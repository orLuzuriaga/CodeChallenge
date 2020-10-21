package com.codeChallenge.codeChallenge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.codeChallenge.codeChallenge.converter.ConverterDto;
import com.codeChallenge.codeChallenge.dto.AddressDto;
import com.codeChallenge.codeChallenge.dto.UserDto;
import com.codeChallenge.codeChallenge.entity.Address;
import com.codeChallenge.codeChallenge.entity.User;
import com.codeChallenge.codeChallenge.error.InvalidInputException;
import com.codeChallenge.codeChallenge.error.UserNotFoundException;
import com.codeChallenge.codeChallenge.repository.AddressRepository;
import com.codeChallenge.codeChallenge.repository.UserRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    

    private final ConverterDto userToConverter;
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;



    /**
     * 
     * @return lista todos los usarios en formato UserDto
    */
    public List<UserDto> getUsers(){
        List<UserDto> users = new ArrayList<>();
        
       
         List<User> result = userRepository.findAll();
         if(!result.isEmpty())
         {
             users = result.stream()
                .map(userToConverter::convertToDto)
                .collect(Collectors.toList());
         }
        return users;
    }


     /**
     * 
     * @return lista todos los usarios habilitadosen formato UserDto
    */
    public List<UserDto> getAllUserEnabled(){
        List<UserDto> users = new ArrayList<>();
    
         List<User> result = userRepository.findByEnabled(true);
         if(!result.isEmpty())
         {
             users = result.stream()
                .map(userToConverter::convertToDto)
                .collect(Collectors.toList());
         }
        return users;
    }


  


  
    
    

    /**
     * 
     * @param newUser
     * @return crea un nuevo usuario, devuelve 405 si la entrada es invalida
     */
    public User saveUser(UserDto newUser)
    {

        try {
            User user = new User();
            user.setName(newUser.getName());
            user.setEmail(newUser.getEmail());
            user.setBirthDate(newUser.getBirthDate());
            user.setAddress(createAddress(newUser.getAddress()));
            user.setEnabled(true);
            userRepository.save(user);
            return user;
        } catch (Exception e) {
            throw new InvalidInputException();
        }
     
    }


    /**
     * 
     * @param id
     * @param editUser
     * @return actualiza un usuario, 400 si no encuentra el usuario
     */
    public User updateUser(Long id, UserDto editUser)
    {
     User updateUser = userRepository.findById(id).map(user -> 
       {
          user.setName(editUser.getName());
          user.setEmail(editUser.getEmail());
          user.setBirthDate(editUser.getBirthDate());
          user.setAddress(createAddress(editUser.getAddress()));
          return user;
       }).orElseThrow(() -> new UserNotFoundException(id));


       return updateUser;

    }

    

  
/**
 * 
 * @param id
 * @return devuelve un usuario en formato UserDto, 404 si no encuentra al usuario
 */

    public UserDto getUser(Long id)
    {
       User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
       UserDto userDto = userToConverter.convertToDto(user);
       return userDto;  
    }





/***
 * 
 * @param id
 * @return el usuario deshabilitado, 404 si no encuentra el usuario
 */
    public User deleteUserById(Long id)
    {
        User disabled = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
        disabled.setEnabled(false);
        userRepository.save(disabled);
       return disabled;
    
    }





/**
 * 
 * @param newAddress
 * @return Devuelve una direccion en formado Address
 */
    private Address createAddress(AddressDto newAddress)
    {
        Address address = new Address();
        address.setStreet(newAddress.getStreet());
        address.setCity(newAddress.getCity());
        address.setState(newAddress.getState());
        address.setCountry(newAddress.getCountry());
        address.setZip(newAddress.getZip());
        addressRepository.save(address);
        return address;
    }


    
}
