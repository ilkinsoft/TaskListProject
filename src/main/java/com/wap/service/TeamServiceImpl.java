package com.wap.service;

import com.wap.model.dao.BaseDao;
import com.wap.model.dao.TeamDao;
import com.wap.model.dto.TaskDto;
import com.wap.model.dto.TeamDto;
import com.wap.model.entity.Task;
import com.wap.model.entity.Team;
import com.wap.model.result.Result;

//@Service
public class TeamServiceImpl implements ITeamService {

    private TeamDao teamDao = new TeamDao();

//    public Student getUserByUserId(long userId){
//        return StreamSupport.stream(studentRepo.findAll().spliterator(), false)
//                .filter(f -> f.getUser().getId() == userId).findFirst().get();
//    }

    @Override
    public TeamDto getTeamById(int id) {
        return teamDao.getById(id);
    }

    @Override
    public Result addTeam(TeamDto teamDto) {
        teamDao.save(teamDto);
        return new Result().makeSuccess();
    }

    @Override
    public Result updateTeam(TeamDto u) {
        teamDao.save(u);
        return new Result().makeSuccess();
    }

    @Override
    public Result deleteTeam(int id) {
        TeamDto teamDto = teamDao.getById(id);
        teamDao.delete(teamDto);
        return new Result().makeSuccess();
    }

//    @Override
//    public List<SectionDto> getAssignedTasks(long userId) {
//        Student student = getStudentByUserId(userId);
//        List<SectionDto> sectionDtoList = new ArrayList<>();
//
//        List<Section> sections = student.getSections();
//        for (Section section : sections) {
//            SectionDto sectionDto = new SectionDto();
//            sectionDto.setId(section.getId());
//            sectionDto.setCourseName(section.getCourse().getName());
//            sectionDto.setCourseCode(section.getCourse().getCode());
//            sectionDto.setBlock(section.getAssignedBlock().getName());
//            sectionDto.setFaculty(section.getFaculty().getFirstName() + " " + section.getFaculty().getLastName());
//            sectionDtoList.add(sectionDto);
//        }
//        return sectionDtoList;
//    }

//    @Override
//    public Result registerForSections(long userId, int[] sectionIdArray) {
//        Student student = getStudentByUserId(userId);
//        List<Section> sections = new ArrayList<>();
//
//        for (int sectionId : sectionIdArray) {
//            Section section = sectionRepo.getSectionById(sectionId);
//            if (section.getCapacity() == section.getEnrolledStudents().size())
//                return new Result(false, section.getCourse().getName() + " - " + section.getFaculty().getFirstName() + " " + section.getFaculty().getLastName() + " section has no available seats!");
//            sections.add(section);
//        }
//        student.setSections(sections);
//        studentRepo.save(student);
//
//        return new Result(true, "Registered for these sections!");
//    }
}
