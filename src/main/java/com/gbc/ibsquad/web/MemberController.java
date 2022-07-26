package com.gbc.ibsquad.web;

import com.gbc.ibsquad.domain.member.Member;
import com.gbc.ibsquad.domain.member.MemberRepository;
import com.gbc.ibsquad.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private final MemberService memberService;

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

    @GetMapping("/listView")
    public String listView(Model model){
        model.addAttribute("members", memberService.getAllMembers());
        return "members/listView";
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
