package com.personal.library.library_management.controller;

import com.personal.library.library_management.entity.Member;
import com.personal.library.library_management.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/add")
    public ResponseEntity<Member> addMember(@RequestBody Member member) {
        Member member1 = memberService.addMember(member);
        return new ResponseEntity<>(member1, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Member>> listMembers() {
        List<Member> memberList = memberService.findAllMembers();
        return new ResponseEntity<>(memberList, HttpStatusCode.valueOf(200));
    }

}
