package com.wap.model.dto;

import com.wap.model.entity.Team;
import com.wap.model.entity.Userr;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class TeamDto extends BaseDto{


        public TeamDto(){

                super.typeTdto=TeamDto.class;
                super.typeTEntoty= Team.class;

        }

        private String name;

        private List<Userr> members;

}

