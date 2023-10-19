package com.garage.demo.repository;


import com.garage.demo.model.UserDtls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<UserDtls, Integer> {

    public boolean existsByEmail(String email);
    List<UserDtls> findByRol(String rol);

    public UserDtls findByEmail(String email);

}