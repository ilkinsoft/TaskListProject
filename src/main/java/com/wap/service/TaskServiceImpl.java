package com.wap.service;

import com.wap.model.dao.TaskDao;
import com.wap.model.dto.TaskDto;
import com.wap.model.enums.ResultCode;
import com.wap.model.result.Result;
import com.wap.model.result.ResultData;

import java.util.List;

//@Service
public class TaskServiceImpl implements ITaskService {

    private TaskDao taskDao = new TaskDao();

//    public Student getUserByUserId(long userId){
//        return StreamSupport.stream(studentRepo.findAll().spliterator(), false)
//                .filter(f -> f.getUser().getId() == userId).findFirst().get();
//    }

    @Override
    public ResultData<List<TaskDto>> getTasks() {
        ResultData<List<TaskDto>> resultData = new ResultData<>();
        resultData.setData(taskDao.getAll());
        resultData.setResultCode(ResultCode.SUCCESS);
        return resultData;
    }

    @Override
    public TaskDto getTaskById(int id) {
        return taskDao.getById(id);
    }

    @Override
    public Result addTask(TaskDto taskDto) {
        taskDao.save(taskDto);
        return new Result().makeSuccess();
    }

    @Override
    public Result updateTask(TaskDto u) {
        taskDao.update(u);
        return new Result().makeSuccess();
    }

    @Override
    public Result deleteTask(int id) {
        TaskDto taskDto = taskDao.getById(id);
        taskDao.delete(taskDto);
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
