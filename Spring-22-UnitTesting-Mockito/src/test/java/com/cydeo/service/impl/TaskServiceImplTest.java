package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.entity.Task;
import com.cydeo.mapper.TaskMapper;
import com.cydeo.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {
    @Mock
    TaskRepository taskRepository;
    @Mock
    TaskMapper taskMapper;
    @InjectMocks
    // There is not gonna be null object.
    TaskServiceImpl taskService;

    @ParameterizedTest
    @ValueSource(longs = {1L, 2L, 3L, -5L })
    void findBYId_test(long arg) {

        //GIVEN-preparation
        Task task = new Task();
// since it is returning optional
        when(taskRepository.findById(arg)).thenReturn(Optional.of(task));
        when(taskMapper.convertToDTO(task)).thenReturn(new TaskDTO());

        //WHEN
        taskService.findById(arg);

        //THEN
        verify(taskRepository).findById(arg);
        //other way :
        verify(taskRepository).findById(anyLong());
        verify(taskMapper).convertToDTO(any(Task.class));
        verify(taskMapper).convertToDTO(task);

        verify(taskRepository, never()).findById(-5L);

    }
    @Test
    void findById_bdd_test(){
        //Given
        Task task =new Task();

        given(taskRepository.findById(anyLong())).willReturn(Optional.of(task));
        // Above the same as --> when(taskRepository.findById(arg)).thenReturn(Optional.of(task));
        //given and willReturn is coming from BDDMockito class.

        given(taskMapper.convertToDTO(task)).willReturn(new TaskDTO());

        //When--> it is exactly the same
        taskService.findById(anyLong());

        //Then: then --> should structure is used.
        then(taskRepository).should().findById(anyLong());
        then(taskRepository).should(never()).findById(-5L);


    }





}