package com.pkmn.api.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pkmn.api.user.entities.User;

public interface UserRepository extends JpaRepository<User,Long>{
    
}
