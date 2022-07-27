package com.gbc.ibsquad.service.member;

import com.gbc.ibsquad.domain.member.Member;
import com.gbc.ibsquad.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberRepository memberRepository;

    //CRUD
    @Override
    public void saveMember(Member member){
        this.memberRepository.save(member);
    }

    @Override
    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    @Override
    public void deleteMemberById(Long id){
        memberRepository.deleteById(id);
    }

    @Override
    public Member getMemberById(Long id){
        Optional<Member> optionalMember = memberRepository.findById(id);
        Member member = null;
        if(optionalMember.isPresent()){
            member = optionalMember.get();
        } else {
            throw new RuntimeException("Employee not found for id::" + id);
        }
        return member;
    }
}
