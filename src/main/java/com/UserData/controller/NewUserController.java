package com.UserData.controller;

import com.UserData.model.User;
import com.UserData.service.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NewUserController {
    @Autowired UserRepository userRepository;

   private Logger logger = LoggerFactory.getLogger(this.getClass());

   // @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600, methods = RequestMethod.POST)
    @PostMapping("/newuser")
    public ResponseEntity<User> newUser( @RequestBody User user ){
     User myUser = new User();
     user.setId(myUser.getId());
     logger.info(myUser.toString());
     try{
         userRepository.save(user);
         return new ResponseEntity<User>(user,null, HttpStatus.CREATED);
     }catch (Exception e)
     {
         e.printStackTrace();
         return new ResponseEntity<User>(user,null, HttpStatus.BAD_REQUEST);
     }


    }
}
