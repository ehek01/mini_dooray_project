package com.nhnacademy.account_api_server.domain;

import jdk.jfr.DataAmount;
import lombok.Data;

@Data
public class MemberRegisterRequest {
    private String username;
    private String password;
    private String email;
}
