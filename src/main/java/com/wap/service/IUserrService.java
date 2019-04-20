package com.wap.service;

import com.wap.model.dto.TaskDto;
import com.wap.model.dto.UserDto;
import com.wap.model.entity.Userr;
import com.wap.model.result.Result;
import com.wap.model.result.ResultData;

import java.util.List;

public interface IUserrService {

//    List<UserDto> getUsers();
    UserDto getUserById(int id);
    Result addUser(UserDto u);
    Result updateUser(UserDto u);
    Result deleteUser(int id);

//    List<TaskDto> getTasks(int userId);
//    Result assignTask(int userId, int taskId);
}