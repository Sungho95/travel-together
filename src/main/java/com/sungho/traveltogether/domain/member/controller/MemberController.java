package com.sungho.traveltogether.domain.member.controller;

import com.sungho.traveltogether.domain.member.controller.dto.MemberJoinDto;
import com.sungho.traveltogether.domain.member.controller.dto.MemberLoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/members")
@Valid
public class MemberController {

    @GetMapping("/join")
    public String joinForm(Model model) {

        model.addAttribute("joinForm", new MemberJoinDto());

        return "members/join";
    }

    @PostMapping("/join")
    public String join(@Valid @ModelAttribute("member") MemberJoinDto memberJoinDto, BindingResult result) {

        if (result.hasErrors()) {
            return "members/join";
        }


    }

    @GetMapping("/login")
    public String loginForm(Model model) {

        model.addAttribute("loginForm", new MemberLoginDto());

        return "members/login";
    }
}
