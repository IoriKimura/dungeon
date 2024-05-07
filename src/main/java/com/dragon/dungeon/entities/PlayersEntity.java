package com.dragon.dungeon.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "players")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IdClass(PlayersId.class)
public class PlayersEntity {
    
    @Id
    @ManyToOne
    @JoinColumn(name = "gameId")
    private GameEntity gameId;

    @Id
    @ManyToOne
    @JoinColumn(name = "playerId")
    private UserEntity playerId;

    @Column(name = "isMaster", nullable = false)
    private boolean isMaster;
}

