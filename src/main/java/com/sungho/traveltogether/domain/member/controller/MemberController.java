package com.sungho.traveltogether.domain.member.controller;

import com.sungho.traveltogether.domain.member.controller.dto.MemberJoinDto;
import com.sungho.traveltogether.domain.member.controller.dto.MemberLoginDto;
import com.sungho.traveltogether.domain.member.entity.Member;
import com.sungho.traveltogether.domain.member.mapper.MemberMapper;
import com.sungho.traveltogether.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Valid
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    private final MemberMapper mapper;

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

        Member member = mapper.memberJoinDtoToMember(memberJoinDto);
        Member createdMember = memberService.createMember(member);

        log.info("createdMemberId={}", createdMember.getId());

        return "redirect:/members/login";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {

        model.addAttribute("loginForm", new MemberLoginDto());

        return "members/login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("member") MemberLoginDto memberLoginDto, BindingResult result) {

        if (result.hasErrors()) {
            return "members/login";
        }

        return "redirect:/";
    }
}
