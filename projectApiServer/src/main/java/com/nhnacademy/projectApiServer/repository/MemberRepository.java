package com.nhnacademy.projectApiServer.repository;

import com.nhnacademy.projectApiServer.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
