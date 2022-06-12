package com.nhnacademy.projectApiServer.controller;

import com.nhnacademy.projectApiServer.domain.ProjectDto;
import com.nhnacademy.projectApiServer.domain.ProjectMemberDto;
import com.nhnacademy.projectApiServer.domain.ProjectMemberRegisterReq;
import com.nhnacademy.projectApiServer.domain.ProjectRegisterRequest;
import com.nhnacademy.projectApiServer.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectRestController {
    private final ProjectService projectService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register/{createUserId}")
    public ProjectDto projectRegister(@RequestBody ProjectRegisterRequest req,
                                      @PathVariable Long createUserId) {

        return projectService.projectRegister(req, createUserId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/member/register/{adminUserId}")
    public ProjectMemberDto projectMemberRegister(@RequestBody ProjectMemberRegisterReq req,
                                                  @PathVariable Long adminUserId) {

        return projectService.projectMemberRegister(req.getMemberId(), adminUserId);
    }
}
