package com.UserData.service;

import com.UserData.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

List<User> getUserByEmail(String email);

}
