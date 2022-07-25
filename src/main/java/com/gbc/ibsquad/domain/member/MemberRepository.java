package com.gbc.ibsquad.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface MemberRepository extends JpaRepository<Member,Long> {
//    List<Member> findById(Long id);

//    List<Member> findByMemberNameLike(String name);


}
