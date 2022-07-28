package com.gbc.ibsquad.service.member;

import com.gbc.ibsquad.domain.member.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    //CRUD
    void saveMember(Member member);
    List<Member> getAllMembers();
    Member getMemberById(Long id);
    Optional<Member> getMemberByloginId(String loginId);
    void deleteMemberById(Long id);
}
