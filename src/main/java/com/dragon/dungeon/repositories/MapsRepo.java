package com.dragon.dungeon.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dragon.dungeon.entities.MapEntity;
import com.dragon.dungeon.entities.UserEntity;

@Repository
public interface MapsRepo extends JpaRepository<MapEntity, UUID>{

    @Query(value = "INSERT INTO maps (id, owner_id, data) VALUES (:id, :userId, CAST(:data AS jsonb)) RETURNING *", nativeQuery = true)
    public MapEntity saveMapAndReturn(@Param("id") UUID id, @Param("userId") UUID userId, @Param("data") String data);

    List<MapEntity> findByOwnerId(UserEntity owner);


}
    
