package com.gbc.ibsquad.web;

import com.gbc.ibsquad.domain.member.Member;
import com.gbc.ibsquad.domain.member.MemberManualRepository;
import com.gbc.ibsquad.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberRepository memberRepository;

    @GetMapping("/register")
    public String addForm(@ModelAttribute("member") Member member){
        return "members/register";
    }

//    @GetMapping("/read")
//    public Member findMember(@PathVariable Long id){
//        Optional<Member> member = Optional.ofNullable(memberRepository.findByLongId(id));
//        return member.get();
//    }

//    @GetMapping("{id}/edit")
//    public String editForm(@PathVariable Long id, Model model){
//        Member member = memberRepository.findById(id);
//
//    }

//    @PostMapping("{id}/edit")

    @PostMapping("/register")
    public String save(@Valid @ModelAttribute Member member, BindingResult result){
        if (result.hasErrors()){
            return "members/register";
        }
        memberRepository.save(member);
        return "redirect:/";
    }


}
