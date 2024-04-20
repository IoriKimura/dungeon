package com.dragon.dungeon.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class RegisterRequest {

    private final String uName;

    private final String uMail;

    private final String uPwd;
}
