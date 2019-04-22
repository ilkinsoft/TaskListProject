package com.wap.service;

import com.wap.model.dto.UserDto;
import com.wap.model.result.Result;
import com.wap.model.result.ResultData;

import java.util.List;

public interface IUserrService {

    List<UserDto> getUsers();

    ResultData<UserDto> getUserById(int id);

    ResultData<UserDto> getUserByEmail(String email);


    Result addUser(UserDto u);

    Result updateUser(UserDto u);

    Result deleteUser(int id);

    ResultData<List<UserDto>> getAllUsers();



//    List<TaskDto> getTasks(int userId);
//    Result assignTask(int userId, int taskId);
}