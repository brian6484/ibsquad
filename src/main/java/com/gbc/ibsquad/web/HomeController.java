package com.gbc.ibsquad.web;

import com.gbc.ibsquad.domain.member.Member;
import com.gbc.ibsquad.domain.member.MemberRepository;
import com.gbc.ibsquad.service.member.MemberService;
import com.gbc.ibsquad.web.session.SessionConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {
    private final MemberService memberService;

    @GetMapping("/")
    public String homeLogin(HttpServletRequest request, Model model){
        HttpSession session = request.getSession(false);
        if(session == null){
            return "home";
        }
        //login
        Member loginMember = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
        if(loginMember==null){
            return "home";
        }
        //if session is valid, go to login
        model.addAttribute("member", loginMember);
        return "loginHome";
    }
}
