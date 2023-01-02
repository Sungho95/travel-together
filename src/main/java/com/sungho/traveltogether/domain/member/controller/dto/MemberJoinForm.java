package com.sungho.traveltogether.domain.member.controller.dto;

import com.sungho.traveltogether.domain.GenderType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Getter
@Setter
public class MemberJoinForm {

    @NotBlank
    private String name;

    @NotBlank
    private String nickname;

    @NotBlank
    @Email(message = "이메일 형식에 맞게 작성해야 합니다.")
    private String email;

    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",
            message = "비밀번호는 8자 이상의 문자와 숫자로 구성되어야 합니다.")
    private String password;

    @NotBlank
    @Pattern(regexp = "^010-\\d{3,4}-\\d{4}$",
            message = "휴대폰 번호는 010으로 시작하는 11자리 숫자와 '-'로 구성되어야 합니다.")
    private String phone;

    @NotBlank
    private LocalDateTime dateOfBirth;

    @NotBlank
    private GenderType genderType;
}
