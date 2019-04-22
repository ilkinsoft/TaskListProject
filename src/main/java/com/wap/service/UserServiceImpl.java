package com.wap.service;

import com.wap.model.dao.BaseDao;
import com.wap.model.dao.UserDao;
import com.wap.model.dto.UserDto;
import com.wap.model.entity.Userr;
import com.wap.model.enums.ResultCode;
import com.wap.model.result.Result;
import com.wap.model.result.ResultData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

//@Service
public class UserServiceImpl implements IUserrService {

    private UserDao userDao = new UserDao();

//    public Student getUserByUserId(long userId){
//        return StreamSupport.stream(studentRepo.findAll().spliterator(), false)
//                .filter(f -> f.getUser().getId() == userId).findFirst().get();
//    }

    @Override
    public List<UserDto> getUsers(){
        return userDao.getAll();
    }

    @Override
    public ResultData<List<UserDto>> getAllUsers() {
        ResultData<List<UserDto>> resultData = new ResultData<>();

        resultData.setData(userDao.getAll());
        resultData.setResultCode(ResultCode.SUCCESS);


        return resultData;
    }

    @Override
    public ResultData<UserDto> getUserById(int id) {
        ResultData<UserDto> resultData = new ResultData<>();
        resultData.setData(userDao.getById(id));
        resultData.setResultCode(ResultCode.SUCCESS);
        return resultData;
    }


    @Override
    public ResultData<UserDto> getUserByEmail(String email) {
        ResultData<UserDto> resultData = new ResultData<>();
        resultData.setData(userDao.getByEmail(email));
        resultData.setResultCode(ResultCode.SUCCESS);
        return resultData;
    }

    @Override
    public Result addUser(UserDto userDto) {
        userDao.save(userDto);
        return new Result().makeSuccess();
    }

    @Override
    public Result updateUser(UserDto u) {
        userDao.update(u);
        return new Result().makeSuccess();
    }

    @Override
    public Result deleteUser(int id) {
        UserDto userDto = userDao.getById(id);
        userDao.delete(userDto);
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
