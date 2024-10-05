package com.personal.library.library_management.service;

import com.personal.library.library_management.entity.Member;
import com.personal.library.library_management.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member addMember(Member member) {
        Member member1 = this.memberRepository.save(member);
        return member1;
    }

    public List<Member> findAllMembers() {
        List<Member> memberList = this.memberRepository.findAll();
        return memberList;
    }
}
