package com.wap.model.entity;

import com.wap.model.enums.Priority;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
//@Proxy(lazy = false)
public class Task extends BaseEntity {

    private String textOfTask;
    private boolean isDone;

    @ManyToOne(cascade = CascadeType.ALL)
    private Userr createdBy;

    @ManyToOne(cascade = CascadeType.ALL)
    private Userr assignedTo;

    private LocalDate createdAt;

    private LocalDate dueDate;

    private Priority priority;


}
