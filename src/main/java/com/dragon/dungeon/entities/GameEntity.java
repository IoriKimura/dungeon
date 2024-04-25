package com.dragon.dungeon.entities;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "games")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameEntity {
    
    @Id
    @UuidGenerator
    private UUID id;

    @OneToMany(mappedBy = "gameId", fetch = FetchType.LAZY)
    // @JoinColumn(name = "ownerId", nullable = false)
    private List<PlayersEntity> ownerId;

    @ManyToOne
    @JoinColumn(name = "mapId", nullable = false)
    private MapEntity mapId;
}
