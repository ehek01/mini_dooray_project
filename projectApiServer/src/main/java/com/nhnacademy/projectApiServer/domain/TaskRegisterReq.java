package com.nhnacademy.projectApiServer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRegisterReq {
    private String taskName;
    private LocalDateTime taskExpectedCompleteDt;
    private LocalDateTime taskCompletedDt;
}
