package com.gbc.ibsquad;

import com.gbc.ibsquad.domain.member.Member;
import com.gbc.ibsquad.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@RequiredArgsConstructor
public class TestDataInit {
    private final MemberService memberService;

    @EventListener(ApplicationReadyEvent.class)
    public void initData(){
//        log.info("test data init");
//        memberService.saveMember(new Member());
    }
}
