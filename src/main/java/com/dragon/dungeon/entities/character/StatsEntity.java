package com.dragon.dungeon.entities.character;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stats")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatsEntity {
    
    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "bonus", nullable = false)
    private int bonus;

    @Column(name = "strenght", nullable = false)
    private int strenght;

    @Column(name = "dexterity", nullable = false)
    private int dexterity;
    
    @Column(name = "constitution", nullable = false)
    private int constitution;

    @Column(name = "intelligence", nullable = false)
    private int intelligence;

    @Column(name = "wisdom", nullable = false)
    private int wisdom;

    @Column(name = "charisma", nullable = false)
    private int charisma;

    @Column(name = "armor")
    private int armor;

    @Column(name = "initiative")
    private int initiative;

    @Column(name = "speed", nullable = false)
    private int speed;

    @Column(name = "hitDice", nullable = false)
    private String hitDice;

    @Column(name = "hp")
    private int hp;

}
