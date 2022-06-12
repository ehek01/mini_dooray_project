package com.nhnacademy.account_api_server.controller;

import com.nhnacademy.account_api_server.domain.MemberDto;
import com.nhnacademy.account_api_server.domain.MemberRegisterRequest;
import com.nhnacademy.account_api_server.sevice.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberRestController {
    private final MemberService memberService;

    // 회원가입
    @PostMapping("/register")
    public MemberDto register(@RequestBody MemberRegisterRequest req) {
        return memberService.register(req);
    }
}