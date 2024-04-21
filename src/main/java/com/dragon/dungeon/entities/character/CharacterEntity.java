package com.dragon.dungeon.entities.character;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.dragon.dungeon.entities.UserEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "characters")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CharacterEntity {

    @Id
    @UuidGenerator
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private UserEntity ownerId;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stats_id", nullable = false)
    private StatsEntity stratsId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "throws_id", nullable = false)
    private SavingThrowsEntity throwsId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skills_id", nullable = false)
    private SkillsEntity skillsId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id", nullable = false)
    private InventoryEntity inventoryId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attack_id", nullable = false)
    private AttackSpellsEntity attackId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feature_id", nullable = false)
    private FeaturesEntity featuresId;

    @Column(name = "name", nullable = false)
    private String cName;

    @Column(name = "race", nullable = false)
    private String cRace;

    @Column(name = "class", nullable = false)
    private String cClass;

    @Column(name = "background")
    private String background;

    @Column(name = "level")
    private String level;
}
