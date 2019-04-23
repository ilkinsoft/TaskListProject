package com.wap.service;

import com.wap.model.dto.TaskDto;
import com.wap.model.dto.TeamDto;
import com.wap.model.result.Result;
import com.wap.model.result.ResultData;

import java.util.List;

public interface ITeamService {

    ResultData<List<TeamDto>> getTeams();
    TeamDto getTeamById(int id);
    Result addTeam(TeamDto u);
    Result updateTeam(TeamDto u);
    Result deleteTeam(int id);
}