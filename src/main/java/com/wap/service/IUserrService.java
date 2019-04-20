package com.wap.service;

import com.wap.model.Task;
import com.wap.model.Userr;

import java.util.List;

public interface IUserrService {

    List<UserDto> getUsers();
    Userr getUserById(long id);
    Result addUserr(Userr u);
    String updateUserr(Userr u);
    String deleteUserr(long id);

    List<Task> getTasks(long userId);
    Result assignTask(long userId, int[] sectionIdArray);
}