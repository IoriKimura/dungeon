package com.dragon.dungeon.entities.character;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "skills")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SkillsEntity {

    @Id
    @UuidGenerator
    private UUID id;
    
    @Column(name = "acrobatics")
    private int acrobatics;
    
    @Column(name = "animalH")
    private int animalH;

    @Column(name = "arcana")
    private int arcana;

    @Column(name = "athletics")
    private int athletics;

    @Column(name = "deception")
    private int deception;

    @Column(name = "history")
    private int history;

    @Column(name = "insight")
    private int insight;

    @Column(name = "intimidation")
    private int intimidation;

    @Column(name = "investigation")
    private int investigation;

    @Column(name = "medicine")
    private int medicine;

    @Column(name = "nature")
    private int nature;

    @Column(name = "perception")
    private int perception;

    @Column(name = "performance")
    private int performance;

    @Column(name = "persuasion")
    private int persuasion;

    @Column(name = "religion")
    private int religion;

    @Column(name = "sleighH")
    private int sleighH;

    @Column(name = "stealth")
    private int stealth;

    @Column(name = "survival")
    private int survival;
}
