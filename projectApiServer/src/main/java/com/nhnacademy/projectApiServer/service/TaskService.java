package com.nhnacademy.projectApiServer.service;

import com.nhnacademy.projectApiServer.domain.TaskDto;
import com.nhnacademy.projectApiServer.domain.TaskRegisterReq;

public interface TaskService {
    TaskDto register(TaskRegisterReq req, Long projectNo, Long memberId);
}
