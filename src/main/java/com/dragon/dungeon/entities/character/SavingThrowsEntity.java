package com.dragon.dungeon.entities.character;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "saving_throws")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SavingThrowsEntity {
    
    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "isStrength", nullable = false)
    private int isStrength;
    
    @Column(name = "isDexterity", nullable = false)
    private int isDexterity;

    @Column(name = "isConstitution", nullable = false)
    private int isConstitution;

    @Column(name = "isIntelligence", nullable = false)
    private int isIntelligence;

    @Column(name = "isWisdom", nullable = false)
    private int isWisdom;

    @Column(name = "isCharisma", nullable = false)
    private int isCharisma;
}
