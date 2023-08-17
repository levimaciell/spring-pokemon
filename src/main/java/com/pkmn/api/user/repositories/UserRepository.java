package com.pkmn.api.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pkmn.api.user.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    
    
    void deleteByUserNameAndPassword(String userName, String password);
}
