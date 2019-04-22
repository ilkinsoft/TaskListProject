package com.wap.model.dto;

import com.wap.model.entity.Task;
import com.wap.model.entity.Userr;
import com.wap.model.enums.Priority;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
public class TaskDto extends BaseDto {

    public TaskDto(){

        super.typeTdto=TaskDto.class;
        super.typeTEntoty= Task.class;

    }

    private String textOfTask;
    private boolean isDone;

    private UserDto createdBy;

    private UserDto assignedTo;

    private LocalDateTime createdAt;

    private LocalDateTime dueDate;

    private Priority priority;

}
