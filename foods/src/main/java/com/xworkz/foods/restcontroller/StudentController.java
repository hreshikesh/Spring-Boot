package com.xworkz.foods.restcontroller;


import com.xworkz.foods.Service.StudentService;
import com.xworkz.foods.dto.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/result")
    public String getStudentResult(
            @RequestBody Student student) {

        return studentService.getResult(student);
    }

    @GetMapping("/add")
    public int add(
            @RequestParam int a,
            @RequestParam int b) {

        return studentService.addNumbers(a, b);
    }

    @PostMapping("/scholarship")
    public boolean scholarship(
            @RequestBody Student student) {

        return studentService
                .isEligibleForScholarship(student);
    }
}
