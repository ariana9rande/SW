package com.hjh.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignInResultDto extends SignUpResultDto
{
    private String token;

    public SignInResultDto(boolean success, int code, String msg, String token)
    {
        super(success, code, msg);
        this.token = token;
    }
}
