package com.wap.model.dto;

import com.wap.model.entity.Team;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TeamDto extends BaseDto {


    public TeamDto() {

        super.typeTdto = TeamDto.class;
        super.typeTEntoty = Team.class;

    }

    private String name;

    //private List<UserDto> members;

}

