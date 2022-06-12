package com.nhnacademy.account_api_server.repository;

import com.nhnacademy.account_api_server.domain.MemberDto;
import com.nhnacademy.account_api_server.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUsername(String username);
}
