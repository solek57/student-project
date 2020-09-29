package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerStudent;
import edu.javacourse.studentorder.domain.StudentOrder;

public class StudentValidator {
      public  AnswerStudent checkStudent(StudentOrder studentOrder) {
        System.out.println("Student check");
        return new AnswerStudent();
    }
}
