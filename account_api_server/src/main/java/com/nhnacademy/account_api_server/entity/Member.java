package com.nhnacademy.account_api_server.entity;

import com.nhnacademy.account_api_server.domain.MemberDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;
    private String username;
    private String password;
    private String email;
    private String authority;
    private String status;
}
