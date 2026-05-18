package com.xworkz.foods.Service;

import com.xworkz.foods.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public String getResult(Student student) {

        if(student.getMarks() >= 35) {
            return "PASS";
        }

        return "FAIL";
    }

    public int addNumbers(int a, int b) {

        return a + b;
    }

    public boolean isEligibleForScholarship(Student student) {

        return student.getMarks() >= 85;
    }
}
