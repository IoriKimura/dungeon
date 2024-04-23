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

    public static SkillsModel fromEntity(SkillsEntity skills){
        
        return SkillsModel.builder()
            .id(skills.getId())
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
            .build();
    }
    
}
