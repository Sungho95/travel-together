package com.sungho.traveltogether.domain.member.controller;

import com.sungho.traveltogether.domain.member.controller.dto.MemberJoinForm;
import com.sungho.traveltogether.domain.member.controller.dto.MemberLoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/members")
@Valid
public class MemberController {

    @GetMapping("/join")
    public String joinForm(Model model) {

        model.addAttribute("joinForm", new MemberJoinForm());

        return "members/join";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {

        model.addAttribute("loginForm", new MemberLoginForm());

        return "members/login";
    }
}
