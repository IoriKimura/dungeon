package com.dragon.dungeon.services.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "token")
public class TokenProperties {

    private String secret;

    private Long timeToLive;
}
