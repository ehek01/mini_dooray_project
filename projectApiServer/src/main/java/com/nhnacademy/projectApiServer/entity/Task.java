package com.nhnacademy.projectApiServer.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskId;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "task_create_dt")
    private LocalDateTime taskCreateDt;

    @Column(name = "task_expected_complete_dt")
    private LocalDateTime taskExpectedCompleteDt;

    @Column(name = "task_completed_dt")
    private LocalDateTime taskCompletedDt;

    @JoinColumn(name = "member_id")
    @ManyToOne
    public Member member;

    @JoinColumn(name = "project_id")
    @ManyToOne
    public Project project;
}

