package com.sungho.traveltogether.domain.member.controller.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class MemberLoginDto {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

}
