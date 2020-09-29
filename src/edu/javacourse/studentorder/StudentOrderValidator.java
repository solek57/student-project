package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.domain.register.AnswerCityRegister;
import edu.javacourse.studentorder.domain.StudentOrder;
import edu.javacourse.studentorder.mail.MailSender;
import edu.javacourse.studentorder.validator.ChildrenValidator;
import edu.javacourse.studentorder.validator.CityRegisterValidator;
import edu.javacourse.studentorder.validator.StudentValidator;
import edu.javacourse.studentorder.validator.WeedingValidator;

import java.util.LinkedList;
import java.util.List;

public class StudentOrderValidator {

    private CityRegisterValidator cityRegisterValidator;
    private WeedingValidator weedingValidator;
    private ChildrenValidator childrenValidator;
    private StudentValidator studentValidator;
    private MailSender mailSender;

    public StudentOrderValidator() {
        cityRegisterValidator = new CityRegisterValidator();
        weedingValidator = new WeedingValidator();
        childrenValidator = new ChildrenValidator();
        studentValidator = new StudentValidator();
        mailSender = new MailSender();
    }

    public static void main(String[] args) {
        StudentOrderValidator studentOrderValidator = new StudentOrderValidator();
        studentOrderValidator.checkAll();
    }

    public void checkAll() {
        List<StudentOrder> so = readStudentOrder();
        for (StudentOrder studentOrder : so) {
            CheckOneOrder(studentOrder);
            System.out.println();

        }
    }

    public void CheckOneOrder(StudentOrder so) {
        AnswerCityRegister cityAnswer = checkCityRegister(so);
        AnswerChildern childrenAnswer = checkChildren(so);
        AnswerStudent studentAnswer = checkStudent(so);
        AnswerWeeding weedingAnswer = checkWedding(so);
        sendMail(so);
    }

    //проверка в регистре
    public AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        return cityRegisterValidator.checkCityRegister(studentOrder);
    }

    public AnswerWeeding checkWedding(StudentOrder studentOrder) {
        return weedingValidator.checkWedding(studentOrder);
    }

    public AnswerChildern checkChildren(StudentOrder studentOrder) {
        return childrenValidator.checkChildren(studentOrder);
    }

    public AnswerStudent checkStudent(StudentOrder studentOrder) {
        return studentValidator.checkStudent(studentOrder);
    }

    public List<StudentOrder> readStudentOrder() {
        List<StudentOrder> studentOrdersList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            studentOrdersList.add(SaveStudentOrder.buildStudentOrder(i));
        }
        return studentOrdersList;
    }


    private void sendMail(StudentOrder so) {

    }
}





