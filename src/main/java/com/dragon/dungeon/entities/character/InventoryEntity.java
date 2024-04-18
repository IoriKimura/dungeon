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
@Table(name = "inventory")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryEntity {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "plat")
    private int plat;

    @Column(name = "gold")
    private int gold;

    @Column(name = "silver")
    private int silver;
    
    @Column(name = "copper")
    private int copper;

    @Column(name = "content")
    private String content;
    
}
