package com.nhnacademy.account_api_server.sevice.impl;

import com.nhnacademy.account_api_server.domain.MemberDto;
import com.nhnacademy.account_api_server.domain.MemberRegisterRequest;
import com.nhnacademy.account_api_server.entity.Member;
import com.nhnacademy.account_api_server.repository.MemberRepository;
import com.nhnacademy.account_api_server.sevice.MemberService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    @Override
    public MemberDto register(MemberRegisterRequest req) {
        MemberDto result = null;

        Optional<Member> findMember = memberRepository.findByUsername(req.getUsername());
        if (findMember.isEmpty()) {
            Member member = Member.builder()
                    .username(req.getUsername())
                    .password(req.getPassword())
                    .email(req.getEmail())
                    .authority("user")
                    .status("enable")
                    .build();
            result = modelMapper.map(memberRepository.save(member), MemberDto.class);
        }
        return result;
    }
}