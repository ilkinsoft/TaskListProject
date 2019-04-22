package com.wap.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;


@Entity
@Setter
@Getter
//@Proxy(lazy = false)

public class Team  extends BaseEntity{

    private String name;

//    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
//    private List<Userr> members;

}
