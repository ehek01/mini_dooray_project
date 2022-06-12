package com.nhnacademy.projectApiServer.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "projectmember")
public class ProjectMember {
    @EmbeddedId
    private Id projectMemberId;

    @Column(name = "adminyn")
    private String adminYn;

    @MapsId("memberId")
    @JoinColumn(name = "member_id")
    @ManyToOne
    public Member member;

    @MapsId("projectId")
    @JoinColumn(name = "project_id")
    @ManyToOne
    public Project project;

    @Embeddable
    @EqualsAndHashCode
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Id implements Serializable {
        private Long memberId;
        private Long projectId;
    }
}
