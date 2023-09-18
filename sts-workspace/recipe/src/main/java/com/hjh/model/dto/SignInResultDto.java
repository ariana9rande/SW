package com.hjh.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SignInResultDto extends SignUpResultDto
{
    private String token;

    @Builder
    public SignInResultDto(boolean success, int code, String msg, String token)
    {
        super(success, code, msg);
        this.token = token;
    }
}
