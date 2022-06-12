package com.nhnacademy.account_api_server.sevice;

import com.nhnacademy.account_api_server.domain.MemberDto;
import com.nhnacademy.account_api_server.domain.MemberRegisterRequest;

public interface MemberService {
    MemberDto register(MemberRegisterRequest req);
}
