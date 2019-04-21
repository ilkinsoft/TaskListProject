package com.wap.model.dao;

import com.wap.model.dto.TeamDto;
import com.wap.model.entity.Team;

public class TeamDao extends BaseDao<Team, TeamDto> {

    public TeamDao() {
        super.typeTDto= TeamDto.class;
        super.typeTEntity= Team.class;

    }

}
