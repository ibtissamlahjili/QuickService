package com.garage.demo.service;

import com.garage.demo.model.UserDtls;
import com.garage.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public UserDtls createUser(UserDtls user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");

        return userRepo.save(user);
    }

    @Override
    public boolean checkEmail(String email) {

        return userRepo.existsByEmail(email);
    }


    public void UserServiceImpl(UserRepository userRepository) {
        this.userRepo = userRepository;
    }

    public List<UserDtls> getAllClients() {
        return userRepo.findByRol("CLIENT");
    }



    public UserDtls getUserById(int id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(long id) {

    }



    public void deleteUserById(int id) {
        userRepo.deleteById(id);
    }

    public UserDtls getRDVById(int id) {
        return userRepo.findById(id).get();
    }

    }

