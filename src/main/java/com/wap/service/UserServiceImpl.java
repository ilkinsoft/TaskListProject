package com.wap.service;

import com.wap.model.Userr;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

//@Service
public class UserServiceImpl implements IUserrService {

//    @Autowired
    private IUserRepo userRepo;
//    @Autowired
    private IUserrService taskRepo;


    public Student getUserByUserId(long userId){
        return StreamSupport.stream(studentRepo.findAll().spliterator(), false)
                .filter(f -> f.getUser().getId() == userId).findFirst().get();
    }

    @Override
//    @Secured("ROLE_a")
    public List<UserDto> getUsers() {

        Iterable<Userr> users = userRepo.findAll();
        List<UserDto> result = new ArrayList<UserDto>();

//        for (Student student : students) {
//            StudentDto studentDto = new StudentDto();
//            studentDto.setId(student.getId());
//            studentDto.setFirstName(student.getFirstName());
//            studentDto.setLastName(student.getLastName());
//            studentDto.setGender(student.getGender().name());
//            studentDto.setAge(student.getAge());
//            studentDto.setCountry(student.getCountry().getName());
//            result.add(studentDto);
//        }
        return result;
    }

    @Override
    public Userr getUserById(long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public Result addUser(Userr user) {
        userRepo.save(user);
        return new Result(true, "User added!");
    }

    @Override
    public String updateUser(Userr u) {
        userRepo.save(u);
        return "User updated!";
    }

    @Override
    public String deleteUser(long id) {
        Userr user = userRepo.findById(id).get();
        userRepo.delete(user);
        return "User deleted!";
    }

    @Override
    public List<SectionDto> getAssignedTasks(long userId) {
        Student student = getStudentByUserId(userId);
        List<SectionDto> sectionDtoList = new ArrayList<>();

        List<Section> sections = student.getSections();
        for (Section section : sections) {
            SectionDto sectionDto = new SectionDto();
            sectionDto.setId(section.getId());
            sectionDto.setCourseName(section.getCourse().getName());
            sectionDto.setCourseCode(section.getCourse().getCode());
            sectionDto.setBlock(section.getAssignedBlock().getName());
            sectionDto.setFaculty(section.getFaculty().getFirstName() + " " + section.getFaculty().getLastName());
            sectionDtoList.add(sectionDto);
        }
        return sectionDtoList;
    }

    @Override
    public Result registerForSections(long userId, int[] sectionIdArray) {
        Student student = getStudentByUserId(userId);
        List<Section> sections = new ArrayList<>();

        for (int sectionId : sectionIdArray) {
            Section section = sectionRepo.getSectionById(sectionId);
            if (section.getCapacity() == section.getEnrolledStudents().size())
                return new Result(false, section.getCourse().getName() + " - " + section.getFaculty().getFirstName() + " " + section.getFaculty().getLastName() + " section has no available seats!");
            sections.add(section);
        }
        student.setSections(sections);
        studentRepo.save(student);

        return new Result(true, "Registered for these sections!");
    }
}
