package com.dragon.dungeon.dao;

import org.springframework.stereotype.Component;

import com.dragon.dungeon.dto.models.characterModels.SkillsModel;
import com.dragon.dungeon.entities.character.SkillsEntity;
import com.dragon.dungeon.repositories.character.SkillsRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SkillsDao {

    private final SkillsRepo skillsRepo;

    public SkillsEntity saveEntity(SkillsModel skills){
        return skillsRepo.save(SkillsEntity.builder()
                .acrobatics(skills.getAcrobatics())
                .animalH(skills.getAnimalH())
                .arcana(skills.getArcana())
                .athletics(skills.getAthletics())
                .deception(skills.getDeception())
                .history(skills.getHistory())
                .insight(skills.getInsight())
                .intimidation(skills.getIntimidation())
                .investigation(skills.getInvestigation())
                .medicine(skills.getMedicine())
                .nature(skills.getNature())
                .perception(skills.getPerception())
                .performance(skills.getPerformance())
                .persuasion(skills.getPersuasion())
                .religion(skills.getReligion())
                .sleighH(skills.getSleighH())
                .stealth(skills.getStealth())
                .survival(skills.getSurvival())
            .build());
    }
    
}
