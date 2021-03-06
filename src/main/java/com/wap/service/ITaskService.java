package com.wap.service;

import com.wap.model.dto.TaskDto;
import com.wap.model.dto.UserDto;
import com.wap.model.result.Result;
import com.wap.model.result.ResultData;

import java.util.List;

public interface ITaskService {

    ResultData<List<TaskDto>> getTasks();
    TaskDto getTaskById(int id);
    Result addTask(TaskDto u);
    Result updateTask(TaskDto u);
    Result deleteTask(int id);
}