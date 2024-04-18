package com.dragon.Repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dragon.dungeon.entities.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, UUID>{

    Optional<UserEntity> findByEmail(String email);
}
    
