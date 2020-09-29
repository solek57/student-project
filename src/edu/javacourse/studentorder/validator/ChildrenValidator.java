package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerChildern;
import edu.javacourse.studentorder.domain.StudentOrder;

public class ChildrenValidator {

    public AnswerChildern checkChildren(StudentOrder studentOrder) {
        System.out.println("Childern register is running");
        return new AnswerChildern();
    }
}
