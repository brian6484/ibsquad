package com.gbc.ibsquad.domain.login;

import com.gbc.ibsquad.domain.member.Member;
import com.gbc.ibsquad.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final MemberRepository memberRepository;

    /**
     * if returns null, login has failed
     */
//    public Member login(String loginId, String password){
//        return memberRepository.findById(loginId)
//}
}
