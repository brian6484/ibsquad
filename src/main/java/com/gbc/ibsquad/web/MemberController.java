package com.gbc.ibsquad.web;

import com.gbc.ibsquad.domain.member.Member;
import com.gbc.ibsquad.domain.member.MemberManualRepository;
import com.gbc.ibsquad.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberRepository memberRepository;

    @GetMapping("/register")
    public String addForm(@ModelAttribute("member") Member member){
        return "members/register";
    }

    @PostMapping("/register")
    public String save(@Valid @ModelAttribute Member member, BindingResult result){
        if (result.hasErrors()){
            return "members/register";
        }
        memberRepository.save(member);
        return "redirect:/";
    }


}
