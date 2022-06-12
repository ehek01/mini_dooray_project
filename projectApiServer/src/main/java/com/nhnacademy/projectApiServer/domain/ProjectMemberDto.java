package com.nhnacademy.projectApiServer.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ProjectMemberDto {
    Long memberId;
    Long projectId;
    String adminYn;
}
