package com.nhnacademy.projectApiServer.repository;

import com.nhnacademy.projectApiServer.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
