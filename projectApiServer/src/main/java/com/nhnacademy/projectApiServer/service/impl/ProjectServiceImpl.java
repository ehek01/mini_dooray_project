package com.nhnacademy.projectApiServer.service.impl;

import com.nhnacademy.projectApiServer.domain.ProjectDto;
import com.nhnacademy.projectApiServer.domain.ProjectRegisterRequest;
import com.nhnacademy.projectApiServer.entity.Project;
import com.nhnacademy.projectApiServer.entity.ProjectMember;
import com.nhnacademy.projectApiServer.repository.MemberRepository;
import com.nhnacademy.projectApiServer.repository.ProjectMemberRepository;
import com.nhnacademy.projectApiServer.repository.ProjectRepository;
import com.nhnacademy.projectApiServer.service.ProjectService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;
    private final ProjectMemberRepository projectMemberRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public ProjectDto register(ProjectRegisterRequest req, Long createUserId) {
        ProjectMember projectMember = new ProjectMember();
        ProjectDto result;

        Project project = Project.builder()
                .projectName(req.getProjectName())
                .projectStatus("enable")
                .projectCreateDt(LocalDate.now())
                .build();

        result = modelMapper.map(projectRepository.save(project), ProjectDto.class);

        // project 를 생성한 사용자는 해당 프로젝트의 관리자가 되어야 하기 때문에 projectMember table 에도 column 이 추가되어야 한다.
        ProjectMember.Id id = new ProjectMember.Id(createUserId, result.getProjectId());
        projectMember.setProjectMemberId(id);

        memberRepository.findById(createUserId)
                        .ifPresent(projectMember::setMember);

        projectRepository.findById(result.getProjectId())
                .ifPresent(projectMember::setProject);

        projectMember.setAdminYn("Y");

        projectMemberRepository.save(projectMember);

        return result;
    }
}
