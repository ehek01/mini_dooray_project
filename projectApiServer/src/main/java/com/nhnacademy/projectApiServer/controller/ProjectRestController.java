package com.nhnacademy.projectApiServer.controller;

import com.nhnacademy.projectApiServer.domain.ProjectDto;
import com.nhnacademy.projectApiServer.domain.ProjectRegisterRequest;
import com.nhnacademy.projectApiServer.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectRestController {
    private final ProjectService projectService;

    @PostMapping("/register/{createUserId}")
    public ProjectDto register(@RequestBody ProjectRegisterRequest req,
                               @PathVariable Long createUserId) {

        return projectService.register(req, createUserId);
    }
}
