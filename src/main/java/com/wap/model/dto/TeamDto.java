package com.wap.model.dto;

import com.wap.model.entity.Userr;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class TeamDto extends BaseDto{




        private String name;

        private List<Userr> members;

}

