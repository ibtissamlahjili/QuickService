package com.garage.demo.service;

import com.garage.demo.model.UserDtls;

import java.util.List;

public interface UserService {

    public UserDtls createUser(UserDtls user);

    public boolean checkEmail(String email);
    public List<UserDtls> getAllClients();


    public UserDtls getUserById(int id) ;
    public void deleteById(long id);
    public void deleteUserById(int id);

    public UserDtls getRDVById(int id);


}