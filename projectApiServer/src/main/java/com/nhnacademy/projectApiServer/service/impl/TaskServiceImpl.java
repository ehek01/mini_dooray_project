package com.nhnacademy.projectApiServer.service.impl;

import com.nhnacademy.projectApiServer.domain.TaskDto;
import com.nhnacademy.projectApiServer.domain.TaskRegisterReq;
import com.nhnacademy.projectApiServer.entity.Task;
import com.nhnacademy.projectApiServer.repository.MemberRepository;
import com.nhnacademy.projectApiServer.repository.ProjectRepository;
import com.nhnacademy.projectApiServer.repository.TaskRepository;
import com.nhnacademy.projectApiServer.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.naming.NameAlreadyBoundException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    private final ProjectRepository projectRepository;
    private final MemberRepository memberRepository;

    @SneakyThrows
    @Override
    public TaskDto register(TaskRegisterReq req, Long projectNo, Long memberId) {
        TaskDto result;

        Optional<String> taskName = taskRepository.findTaskNameByProjectNoAndMemberId(projectNo, memberId);
        if (taskName.isPresent()) {
            // 해당 유저에 등록된 동일한 작업이름이 있으면 안됨.
            throw new NameAlreadyBoundException();
        }

        Task task = Task.builder()
                .taskName(req.getTaskName())
                .taskCreateDt(LocalDateTime.now())
                .taskExpectedCompleteDt(req.getTaskCompletedDt())
                .taskCompletedDt(req.getTaskExpectedCompleteDt())
                .build();

        projectRepository.findById(projectNo).ifPresent(task::setProject);
        memberRepository.findById(projectNo).ifPresent(task::setMember);

        result = modelMapper.map(taskRepository.save(task), TaskDto.class);

        return result;
    }
}
