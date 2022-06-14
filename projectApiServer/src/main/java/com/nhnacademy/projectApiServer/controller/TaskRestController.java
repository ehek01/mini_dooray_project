package com.nhnacademy.projectApiServer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskRestController {
    @PostMapping("/register")
    public String taskRegister(@RequestParam("projectNo") Long projectNo,
                               @RequestParam("memberId") Long memberId) {
        // todo : task 를 만들어봅시다.
        System.out.println(projectNo);
        System.out.println(memberId);
        return null;
    }
}
