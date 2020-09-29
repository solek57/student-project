package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerWeeding;
import edu.javacourse.studentorder.domain.StudentOrder;

public class WeedingValidator {
      public AnswerWeeding checkWedding(StudentOrder studentOrder) {
        System.out.println("Wedding run");
        return new AnswerWeeding();
    }
}
