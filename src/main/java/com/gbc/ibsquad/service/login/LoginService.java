package com.gbc.ibsquad.service.login;

import com.gbc.ibsquad.domain.member.Member;
import com.gbc.ibsquad.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final MemberService memberService;

    public Member login(String loginId, String password){
        return memberService.getMemberByloginId(loginId)
                .filter(member -> member.getPassword().equals(password))
                .orElse(null);
    }
}
