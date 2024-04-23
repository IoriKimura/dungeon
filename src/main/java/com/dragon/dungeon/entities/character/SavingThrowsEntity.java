package com.dragon.dungeon.entities.character;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "saving_throws")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SavingThrowsEntity {
    
    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "isStrength", nullable = false)
    private boolean isStrength;
    
    @Column(name = "isDexterity", nullable = false)
    private boolean isDexterity;

    @Column(name = "isConstitution", nullable = false)
    private boolean isConstitution;

    @Column(name = "isIntelligence", nullable = false)
    private boolean isIntelligence;

    @Column(name = "isWisdom", nullable = false)
    private boolean isWisdom;

    @Column(name = "isCharisma", nullable = false)
    private boolean isCharisma;
}
