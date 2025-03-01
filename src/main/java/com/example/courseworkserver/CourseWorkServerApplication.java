package com.example.courseworkserver;

import com.example.courseworkserver.entity.Department;
import com.example.courseworkserver.entity.Faculty;
import com.example.courseworkserver.entity.Person;
import com.example.courseworkserver.entity.Student;
import com.example.courseworkserver.repository.FacultyRepository;
import com.example.courseworkserver.repository.UniobjectRepository;
import com.example.courseworkserver.service.*;
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
    private final UniobjectService uniobjectService;
    private final PersonService personService;

    public static void main(String[] args) {
        SpringApplication.run(CourseWorkServerApplication.class, args);

    }

    @EventListener(ApplicationReadyEvent.class)
    private void test() {
        Faculty faculty1 = new Faculty();
        faculty1.setName("Факультет прикладної математики та інформатики");
        faculty1.setCurricula("Програма навчання");
        faculty1.setFacultyLocation("Університетська, 1");

// Створення декана для факультету
        Person dean1 = new Person();
        dean1.setName("Мельник Олександр Іванович"); // Декан
        dean1.setDateOfBirth(new Date());
        dean1.setSex("Чол.");
        dean1.setNationality("Українець");
        personService.create(dean1);

        faculty1.setChef(dean1);
        facultyService.create(faculty1);

// Створення кафедри в факультеті
        Department department1 = new Department();
        department1.setName("Кафедра теоретичної та прикладної інформатики");
        department1.setBudget(700000.0);
        department1.setTeachingFocus("Алгоритми, аналіз даних, штучний інтелект");
        department1.setMajor(1L);

// Створення завідувача кафедри
        Person headOfDepartment1 = new Person();
        headOfDepartment1.setName("Ковальчук Марія Василівна"); // Завідувач кафедри
        headOfDepartment1.setDateOfBirth(new Date());
        headOfDepartment1.setSex("Жін.");
        headOfDepartment1.setNationality("Українка");
        personService.create(headOfDepartment1);

        department1.setChef(headOfDepartment1);
        departmentService.create(department1);

// Створення студентів, які навчаються на кафедрі
        Student student1 = new Student();
        student1.setNationality("Українець");
        student1.setUniversityGroup("ПМІ-45");
        student1.setName("Гнатюк Андрій Олегович");
        student1.setMajor(1L);
        student1.setSex("Чол.");
        student1.setDateOfBirth(new Date());
        student1.setPracticalExperience(2);
        student1.setAverageMark(92.4F);
        studentService.create(student1);

        Student student2 = new Student();
        student2.setNationality("Українка");
        student2.setUniversityGroup("ПМІ-42");
        student2.setName("Іваненко Олена Сергіївна");
        student2.setMajor(1L);
        student2.setSex("Жін.");
        student2.setDateOfBirth(new Date());
        student2.setPracticalExperience(1);
        student2.setAverageMark(89.7F);
        studentService.create(student2);

// Створення ще одного факультету
        Faculty faculty2 = new Faculty();
        faculty2.setName("Факультет електроніки та комп'ютерних технологій");
        faculty2.setCurricula("Програма навчання");
        faculty2.setFacultyLocation("Драгоманова, 50");

// Створення декана для другого факультету
        Person dean2 = new Person();
        dean2.setName("Сидоренко Ігор Петрович"); // Декан
        dean2.setDateOfBirth(new Date());
        dean2.setSex("Чол.");
        dean2.setNationality("Українець");
        personService.create(dean2);

        faculty2.setChef(dean2);
        facultyService.create(faculty2);

// Створення кафедри в другому факультеті
        Department department2 = new Department();
        department2.setName("Кафедра комп'ютерних систем і мереж");
        department2.setBudget(500000.0);
        department2.setTeachingFocus("Комп'ютерні системи, кібербезпека, мережеві технології");
        department2.setMajor(2L);

// Створення завідувача кафедри
        Person headOfDepartment2 = new Person();
        headOfDepartment2.setName("Бондаренко Сергій Володимирович"); // Завідувач кафедри
        headOfDepartment2.setDateOfBirth(new Date());
        headOfDepartment2.setSex("Чол.");
        headOfDepartment2.setNationality("Українець");
        personService.create(headOfDepartment2);

        department2.setChef(headOfDepartment2);
        departmentService.create(department2);

// Створення студентів, які навчаються на цій кафедрі
        Student student3 = new Student();
        student3.setNationality("Українець");
        student3.setUniversityGroup("КСМ-32");
        student3.setName("Козієнко Віталій");
        student3.setMajor(2L);
        student3.setSex("Чол.");
        student3.setDateOfBirth(new Date());
        student3.setPracticalExperience(1);
        student3.setAverageMark(95.6F);
        studentService.create(student3);


    }

}
