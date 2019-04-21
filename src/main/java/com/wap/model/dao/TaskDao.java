package com.wap.model.dao;

import com.wap.model.dto.TaskDto;
import com.wap.model.entity.Task;

public class TaskDao extends BaseDao<Task, TaskDto> {

    public TaskDao() {
        super.typeTDto= TaskDto.class;
        super.typeTEntity= Task.class;
    }



//    public void save(TaskDto taskDto) {
//        super.save(taskDto);
//    }


}
