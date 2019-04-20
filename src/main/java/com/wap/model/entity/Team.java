package com.wap.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Setter
@Getter
public class Team  extends BaseEntity{



    private String name;

    @OneToMany(mappedBy = "team")
    private List<Userr> members;

}
