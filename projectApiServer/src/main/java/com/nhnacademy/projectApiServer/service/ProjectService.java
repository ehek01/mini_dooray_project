package com.nhnacademy.projectApiServer.service;

import com.nhnacademy.projectApiServer.domain.ProjectDto;
import com.nhnacademy.projectApiServer.domain.ProjectMemberDto;
import com.nhnacademy.projectApiServer.domain.ProjectRegisterRequest;

public interface ProjectService {
    ProjectDto projectRegister(ProjectRegisterRequest req, Long createUser);
    ProjectMemberDto projectMemberRegister(Long memberId, Long adminUserId);
}
