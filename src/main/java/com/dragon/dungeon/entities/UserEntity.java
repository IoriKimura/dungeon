package com.dragon.dungeon.entities;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserEntity {
    
    @Id
    @UuidGenerator
    private UUID userId;

    @Column(name = "uName")
    private String uName;
    
    @Column(name = "uMail")
    private String uMail;

    @Column(name = "uPassword")
    private String uPwd;
}
