package com.dragon.dungeon.dto.models.characterModels;


import java.util.UUID;

import com.dragon.dungeon.entities.character.SkillsEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillsModel {

    private UUID id;
    
    private int acrobatics;
    
    private int animalH;

    private int arcana;

    private int athletics;

    private int deception;

    private int history;

    private int insight;

    private int intimidation;

    private int investigation;

    private int medicine;

    private int nature;

    private int perception;

    private int performance;

    private int persuasion;

    private int religion;

    private int sleighH;

    private int stealth;

    private int survival;

    public static SkillsModel fromEntity(SkillsEntity skils){
        
        return SkillsModel.builder()
            .id(skils.getId())
            .acrobatics(skils.getAcrobatics())
            .animalH(skils.getAnimalH())
            .arcana(skils.getArcana())
            .athletics(skils.getAthletics())
            .deception(skils.getDeception())
            .history(skils.getHistory())
            .insight(skils.getInsight())
            .intimidation(skils.getIntimidation())
            .investigation(skils.getInvestigation())
            .medicine(skils.getMedicine())
            .nature(skils.getNature())
            .perception(skils.getPerception())
            .performance(skils.getPerformance())
            .persuasion(skils.getPersuasion())
            .religion(skils.getReligion())
            .sleighH(skils.getSleighH())
            .stealth(skils.getStealth())
            .survival(skils.getSurvival())
            .build();
    }
    
}
