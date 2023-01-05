package com.sungho.traveltogether.domain.member.controller.dto;


import javax.validation.constraints.NotBlank;

public class MemberPatchDto {

    private String image;

    @NotBlank
    private String nickname;

    private String location;

    private String aboutMe;

}
