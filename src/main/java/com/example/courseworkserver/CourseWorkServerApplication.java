package com.example.courseworkserver;

import com.example.courseworkserver.entity.Department;
import com.example.courseworkserver.entity.Faculty;
import com.example.courseworkserver.entity.Student;
import com.example.courseworkserver.repository.FacultyRepository;
import com.example.courseworkserver.repository.UniobjectRepository;
import com.example.courseworkserver.service.DepartmentService;
import com.example.courseworkserver.service.FacultyService;
import com.example.courseworkserver.service.RepositoryService;
import com.example.courseworkserver.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.Date;

@SpringBootApplication
@RequiredArgsConstructor
public class CourseWorkServerApplication {

    private final FacultyService facultyService;
    private final StudentService studentService;
    private final DepartmentService departmentService;
    private final RepositoryService repositoryService;

    public static void main(String[] args) {
        SpringApplication.run(CourseWorkServerApplication.class, args);

    }

    @EventListener(ApplicationReadyEvent.class)
    private void test() {
        Faculty faculty = new Faculty();
        faculty.setChef("Chef1");
        faculty.setCurricula("Curricula1");
        faculty.setFacultyLocation("Location1");
        faculty.setName("Fac1");
        facultyService.create(faculty);

        Department department = new Department();
        department.setChef("Chef2");
        department.setBudget(300F);
        department.setName("Dep1");
        department.setTeachingFocus("dsadsadas");
        department.setMajor(1L);
        departmentService.create(department);

        Department department2 = new Department();
        department2.setChef("Chef3");
        department2.setBudget(300F);
        department2.setName("Dep2");
        department2.setTeachingFocus("dsadsadas");
        department2.setMajor(2L);
        departmentService.create(department2);
    }

}
