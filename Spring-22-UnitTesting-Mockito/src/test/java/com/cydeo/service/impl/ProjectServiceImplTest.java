package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    ProjectRepository projectRepository;

    @Mock
    ProjectMapper projectMapper;

    //We inject mocks to below projectService
    @InjectMocks
    ProjectServiceImpl projectService;

    @Test
    void getByProjectCode_test() {

        //FOR BDD STRUCTURE THIS IS GIVEN PART
        // Create project entity

        Project project = new Project();
        //Return me just project object

        ProjectDTO projectDTO = new ProjectDTO();
        //Return me empty projectDTO;

        //Do static method for mockito methods.
        //anyString gives you some String
        when(projectRepository.findByProjectCode(anyString())).thenReturn(project);

        when(projectMapper.convertToDto(project)).thenReturn(projectDTO);

        //FOR BDD STRUCTURE THIS IS WHEN PART
        //This is the real part of testing.
        ProjectDTO projectDTO1 = projectService.getByProjectCode(anyString());

        //FOR BDD STRUCTURE THIS IS THEN PART
        verify(projectRepository).findByProjectCode(anyString());

        //you can use project entity instead of any method.
        verify(projectMapper).convertToDto(any(Project.class));

        //assertion
        assertNotNull(projectDTO1);

    }

    @Test
    void getByProjectCode_exception_test() {
        //If get by project code find empty code then get this message.
        when(projectRepository.findByProjectCode("")).thenThrow(new RuntimeException("Project Not Found"));

        Throwable exception = assertThrows(RuntimeException.class, () -> projectService.getByProjectCode(""));

        verify(projectRepository).findByProjectCode(anyString());

        assertEquals("Project Not Found", exception.getMessage());

    }

    @Test
    void save_test() {

        ProjectDTO projectDTO = new ProjectDTO();
        Project project = new Project();

//It means that when I use project mapper convert to entity on this test
// return me instead of executing real one, just an empty entity
// because convert to entity should return me entity.
        when(projectMapper.convertToEntity(projectDTO)).thenReturn(project);

// when you see project repository.save method with some project entity return me some project entity.
        when(projectRepository.save(project)).thenReturn(project);
        // UP to now I defined how to mock should act.

//WHEN part:
        projectService.save(projectDTO);

        //THEN part:
        verify(projectRepository).save(project);
        verify(projectMapper).convertToEntity(any(ProjectDTO.class));

    }



}