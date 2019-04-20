package com.wap.model.dto;

import com.wap.model.entity.Userr;
import com.wap.model.enums.Priority;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class TaskDto extends BaseDto {



    private String textOfTask;
    private boolean isDone;

    private Userr createdBy;

    private Userr assignedTo;

    private LocalDate createdAt;

    private LocalDate dueDate;

    private Priority priority;

}
