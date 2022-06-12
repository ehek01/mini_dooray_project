package com.nhnacademy.projectApiServer.repository;

import com.nhnacademy.projectApiServer.entity.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMember.Id> {
}
