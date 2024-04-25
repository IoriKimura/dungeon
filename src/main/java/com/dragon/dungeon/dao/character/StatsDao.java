package com.dragon.dungeon.dao.character;

import org.springframework.stereotype.Component;

import com.dragon.dungeon.dto.models.characterModels.StatsModel;
import com.dragon.dungeon.entities.character.StatsEntity;
import com.dragon.dungeon.repositories.character.StatsRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StatsDao {

    private final StatsRepo statsRepo;

    public StatsEntity saveEntity(StatsModel stats){
        return statsRepo.save(StatsEntity.builder()
                .bonus(stats.getBonus())
                .strenght(stats.getStrenght())
                .dexterity(stats.getDexterity())
                .constitution(stats.getConstitution())
                .intelligence(stats.getIntelligence())
                .wisdom(stats.getWisdom())
                .charisma(stats.getCharisma())
                .armor(stats.getArmor())
                .initiative(stats.getInitiative())
                .speed(stats.getSpeed())
                .hitDice(stats.getHitDice())
                .hp(stats.getHp())
            .build());
    }
}
