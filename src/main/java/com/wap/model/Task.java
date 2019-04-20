package com.wap.model;

import com.wap.model.enums.Priority;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
public class Task {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

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
