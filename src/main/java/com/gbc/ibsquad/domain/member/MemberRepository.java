package com.gbc.ibsquad.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
@Repository
public class MemberRepository {
    private static Map<Long, Member> store = new ConcurrentHashMap<>();
    private static long sequence = 0L;

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    public Optional<Member> findByLoginId(String loginId){
//        List<Member> all = findAll();
//        for (Member member : all) {
//            if(member.getLoginId().equals(loginId)){
//                return Optional.of(member);
//            }
//        }
//        return Optional.empty();
        return findAll().stream()
                .filter(member -> member.getLoginId().equals(loginId))
                .findFirst();
    }
    public void clearStore(){
        store.clear();
    }
}
