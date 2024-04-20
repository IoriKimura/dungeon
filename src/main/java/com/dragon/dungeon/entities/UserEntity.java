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
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    
    @Id
    @UuidGenerator
    private UUID userId;

    @Column(name = "u_name", nullable = false)
    private String uName;
    
    @Column(name = "u_mail", nullable = false)
    private String uMail;

    @Column(name = "u_password", nullable = false)
    private String uPwd;
}
