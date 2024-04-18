package com.dragon.dungeon.entities;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "maps")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class MapEntity {
    
    @Id
    @UuidGenerator
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private UserEntity ownerId;

    @Column(name = "data", columnDefinition = "jsonb", nullable = false)
    private String data;
}
