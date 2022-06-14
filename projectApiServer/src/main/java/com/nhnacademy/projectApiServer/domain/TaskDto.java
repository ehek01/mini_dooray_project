package com.nhnacademy.projectApiServer.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskDto {
    private Long taskId;
    private String taskName;
    private LocalDateTime taskCreateDt;
    private LocalDateTime taskExpectedCompleteDt;
    private LocalDateTime taskCompletedDt;
    private Long memberId;
    private Long projectId;
}
