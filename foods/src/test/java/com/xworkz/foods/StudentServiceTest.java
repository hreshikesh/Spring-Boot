package com.xworkz.foods;

import com.xworkz.foods.Service.StudentService;
import com.xworkz.foods.dto.Student;
import org.junit.Test;

public class StudentServiceTest {

    private final StudentService studentService =
            new StudentService();

    @Test
    public void testPassResult() {

        Student student =
                new Student(1, "Rishi", 90);

        String result =
                studentService.getResult(student);

        Assertions.assertEquals(
                "PASS",
                result
        );
    }

    @Test
    public void testFailResult() {

        Student student =
                new Student(2, "Ajay", 20);

        String result =
                studentService.getResult(student);

        Assertions.assertEquals(
                "FAIL",
                result
        );
    }

    @Test
    public void testAddition() {

        int result =
                studentService.addNumbers(10, 20);

        Assertions.assertEquals(
                30,
                result
        );
    }

    @Test
    public void testScholarshipEligible() {

        Student student =
                new Student(3, "Kiran", 95);

        boolean result =
                studentService
                        .isEligibleForScholarship(student);

        Assertions.assertTrue(result);
    }

    @Test
    public void testScholarshipNotEligible() {

        Student student =
                new Student(4, "Arun", 60);

        boolean result =
                studentService
                        .isEligibleForScholarship(student);

        Assertions.assertFalse(result);
    }
}