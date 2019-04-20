package com.wap.model.entity;

import com.wap.model.enums.Priority;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
public class Task extends BaseEntity {




    private String textOfTask;
    private boolean isDone;

    @ManyToOne
    private Userr createdBy;

    @ManyToOne
    private Userr assignedTo;

    private LocalDate createdAt;

    private LocalDate dueDate;

    private Priority priority;


}
