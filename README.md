

## CODE CHALLENGE

Prueba técnica para cloudApi, donde se construye una API son springBoot que gestiona un CRUD  de usuarios

### Estructura del proyecto.
 El proyecto se estructura de la siguiente manera:
  1. controller 
  2. converter
  3. dto
  4. entity
  5. error
  6. repository
  7. service


### Controller
  Controlador donde nos encontramos los siguientes métodos CRUD y donde inyectamos nuestro servicio.
   1. getUser()  
    Devuelve el código 200, junto con una lista de todos los usuarios, devuelve el código 400 si la lista está vacía.
   2. getAllUserEnabled(),  
    Devuelve el código200 y la lista de todos los usuarios habilitados, 400 si la lista está vacia.
   3. createUser(), 
    Devuelve el código 201 y el usuario nuevo, 405 si la entrada es invalida.
   4. getUser(), 
    Devuelve el código 200 y el usuario encontrado, devuelve el código 404 si no se encuentra al usuario y 400 si el id es invalido.
   5. updateUser(), 
   Devuelve el código 200 y el usuario actualizado, devuelve el código 400 si el id es invalido y 404 si no se encuentra al usuario.
   6. deleteUser(), 
   Devuelve el código 200 y el usuario eliminado (deshabilitado), el código  400 si el id es invalido, 404 si no se encuentra al usuario
   
 

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/a10b0ad51a2f8ff58ab7)

