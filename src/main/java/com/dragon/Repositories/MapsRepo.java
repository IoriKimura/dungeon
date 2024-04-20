package com.dragon.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dragon.dungeon.entities.UserEntity;

@Repository
public interface MapsRepo extends JpaRepository<UserEntity, UUID>{

}
    
