package com.gbc.ibsquad.service.member;

import com.gbc.ibsquad.domain.member.Member;

import java.util.List;

public interface MemberService {
    //CRUD
    void saveMember(Member member);
    List<Member> getAllMembers();
    Member getMemberById(Long id);
    void deleteMemberById(Long id);
}
