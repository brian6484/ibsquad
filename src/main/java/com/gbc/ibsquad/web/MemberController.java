package com.gbc.ibsquad.web;

import com.gbc.ibsquad.domain.member.Member;
import com.gbc.ibsquad.domain.member.MemberRepository;
import com.gbc.ibsquad.service.member.MemberService;
import com.gbc.ibsquad.service.member.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @GetMapping("/register")
    public String addMember(@ModelAttribute("member") Member member){
        return "members/register";
    }

    @PostMapping("/register")
    public String saveMember(@Valid @ModelAttribute Member member, BindingResult result){
        if (result.hasErrors()){
            return "members/register";
        }
        memberService.saveMember(member);
        return "redirect:/";
    }

    @GetMapping("/listView")
    public String listView(Model model){
        model.addAttribute("members", memberService.getAllMembers());
        return "members/listView";
    }

    @GetMapping("/updateMember/{id}")
    public String updateMember(@PathVariable(value="id") Long id, Model model){
        Member member = memberService.getMemberById(id);
        model.addAttribute("member", member);
        return "members/update";
    }

    @GetMapping("/deleteMember/{id}")
    public String deleteMember(@PathVariable(value="id") Long id){
        memberService.deleteMemberById(id);
        return "redirect:/";
    }
}
