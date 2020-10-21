package com.codeChallenge.codeChallenge.controller;

import java.util.List;

import com.codeChallenge.codeChallenge.dto.UserDto;
import com.codeChallenge.codeChallenge.error.UserNotValidException;
import com.codeChallenge.codeChallenge.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class UsersController {

    private final UserService userService;




    /**
     *  Obtenemos todos los usuarios 
     * 
     * @return 200 y la lista de todos los usuarios, 400 si la lista es vacia.
     */
    @GetMapping("/getusers")
    public ResponseEntity<?> getAllUsers()
    {
        List<UserDto> users =  userService.getUsers();

        if(users.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(users);
        }
    }


     /**
     *  Obtenemos todos los usuarios habilitados
     * 
     * @return 200 y la lista de todos los usuarios, 400 si la lista es vacia.
     */
    @GetMapping("/getusersenabled")
    public ResponseEntity<?> getAllUsersEnabled()
    {
        List<UserDto> users =  userService.getAllUserEnabled();

        if(users.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(users);
        }
    }






    /**
     * 
     * @param newUser
     * @return 201 y el usuario nuevo, 405 si la entrada es invalida
     */

    @PostMapping("/createUsers")
    public ResponseEntity<?> createUser(@RequestBody UserDto newUser)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(newUser));
    }




/**
 * 
 * @param userId
 * @return 200 y el usuario encontrado, 404 si no se encuentra al usuario, 400 si el id es invalido
 */
    @GetMapping("/getusersById/{userId}")
    public ResponseEntity<?> getUser(@PathVariable Long userId)
    {
      if(userId > 0)
      {
        return ResponseEntity.ok(userService.getUser(userId));
      }else{
        throw new UserNotValidException(userId);
      }
    }



/**
 * 
 * @param userId
 * @param user
 * @return 200 y el usuario actualizado, 400 si el id es invalido, 404 si no se encuentra al usuario
 */
    @PutMapping("/updateUsersById/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody UserDto user)
    {
        if(userId > 0)
        {
         return ResponseEntity.ok().body(userService.updateUser(userId, user));
        }else{
          throw new UserNotValidException(userId);
        }
       
    }



/**
 * 
 * @param userId
 * @return 200 y el usuario eliminado (deshabilitado), 400 si el id es invalido, 404 si no se encuentra al usuario
 */
    @DeleteMapping("/deleteUsersById/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId)
    {
 
        if(userId > 0)
        {
         return ResponseEntity.ok().body(userService.deleteUserById(userId));
        }else{
          throw new UserNotValidException(userId);
        }
      
    }


}
