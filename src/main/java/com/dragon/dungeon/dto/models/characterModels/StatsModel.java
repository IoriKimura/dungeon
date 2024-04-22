package com.dragon.dungeon.dto.models.characterModels;

import java.util.UUID;

import com.dragon.dungeon.entities.character.StatsEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatsModel {

    private UUID id;
    
    private int bonus;
    
    private int strenght;

    private int dexterity;
    
    private int constitution;

    private int intelligence;

    private int wisdom;

    private int charisma;

    private int armor;

    private int initiative;

    private int speed;

    private String hitDice;

    private int hp;

    public static StatsModel fromEntity(StatsEntity statsFromDb){
        
        return StatsModel.builder()
            .id(statsFromDb.getId())
            .bonus(statsFromDb.getBonus())
            .strenght(statsFromDb.getStrenght())
            .dexterity(statsFromDb.getDexterity())
            .constitution(statsFromDb.getConstitution())
            .intelligence(statsFromDb.getIntelligence())
            .wisdom(statsFromDb.getWisdom())
            .charisma(statsFromDb.getCharisma())
            .armor(statsFromDb.getArmor())
            .initiative(statsFromDb.getInitiative())
            .speed(statsFromDb.getSpeed())
            .hitDice(statsFromDb.getHitDice())
            .hp(statsFromDb.getHp())
            .build();

         
    }
}
