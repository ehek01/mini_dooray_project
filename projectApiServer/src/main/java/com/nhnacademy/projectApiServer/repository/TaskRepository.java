package com.nhnacademy.projectApiServer.repository;

import com.nhnacademy.projectApiServer.domain.TaskDto;
import com.nhnacademy.projectApiServer.entity.Member;
import com.nhnacademy.projectApiServer.entity.Project;
import com.nhnacademy.projectApiServer.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Transactional
    @Query(value = "select task_name from task where project_id = ?1 and member_id = ?2", nativeQuery = true)
    Optional<String> findTaskNameByProjectNoAndMemberId(Long projectNo, Long memberId);
}
