package com.nhnacademy.projectApiServer.controller;

import com.nhnacademy.projectApiServer.domain.TaskDto;
import com.nhnacademy.projectApiServer.domain.TaskRegisterReq;
import com.nhnacademy.projectApiServer.entity.Task;
import com.nhnacademy.projectApiServer.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskRestController {
    private final TaskService taskService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    public TaskDto taskRegister(@RequestBody TaskRegisterReq req,
                                @RequestParam("projectNo") Long projectNo,
                                @RequestParam("memberId") Long memberId) {
        return taskService.register(req, projectNo, memberId);
    }

}
