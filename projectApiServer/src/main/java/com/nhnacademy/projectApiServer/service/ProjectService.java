package com.nhnacademy.projectApiServer.service;

import com.nhnacademy.projectApiServer.domain.ProjectDto;
import com.nhnacademy.projectApiServer.domain.ProjectRegisterRequest;

public interface ProjectService {
    ProjectDto register(ProjectRegisterRequest req, Long createUser);
}
