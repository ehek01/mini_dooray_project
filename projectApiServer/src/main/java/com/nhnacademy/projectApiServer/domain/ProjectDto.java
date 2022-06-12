package com.nhnacademy.projectApiServer.domain;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class ProjectDto {
    private Long projectId;
    private String projectName;
    private String projectStatus;
    private LocalDate projectCreateDt;
}
