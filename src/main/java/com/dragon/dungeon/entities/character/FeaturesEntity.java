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
@Table(name = "features")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeaturesEntity {
    
    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "feature")
    private String feature;
}
