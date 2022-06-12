package com.nhnacademy.projectApiServer.repository;

import com.nhnacademy.projectApiServer.entity.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMember.Id> {
    @Transactional
    @Query(value = "select project_id from projectmember where member_id = ?1", nativeQuery = true)
    Long findProjectIdByAdminUserId(Long memberId);
}
