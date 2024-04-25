package com.dragon.dungeon.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dragon.dungeon.entities.MapEntity;

@Repository
public interface MapsRepo extends JpaRepository<MapEntity, UUID>{

    // @Modifying
    @Query(value = "INSERT INTO maps (id, owner_id, data) VALUES (:id, :userId, CAST(:data AS jsonb)) RETURNING *", nativeQuery = true)
    public MapEntity saveMapAndReturn(@Param("id") UUID id, @Param("userId") UUID userId, @Param("data") String data);

}
    
