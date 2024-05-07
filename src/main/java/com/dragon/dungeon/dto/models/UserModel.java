package com.dragon.dungeon.dto.models;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.dragon.dungeon.entities.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel implements UserDetails{

    private UUID id;

    private String uName;

    private String uMail;

    private String uPwd;

    public static UserModel fromEntity(UserEntity user){
        return UserModel.builder()
            .id(user.getUserId())
            .uName(user.getUName())
            .uMail(user.getUMail())
            .uPwd(user.getUPwd())
            .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
        
    }

    @Override
    public String getPassword() {
        return uPwd;
    }

    @Override
    public String getUsername() {
        return uMail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
