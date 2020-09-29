package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.domain.register.AnswerCityRegister;
import edu.javacourse.studentorder.domain.Child;
import edu.javacourse.studentorder.domain.StudentOrder;
import edu.javacourse.studentorder.domain.register.AnswerCityRegisterItem;
import edu.javacourse.studentorder.domain.register.CityRegisterCheckerResponse;
import edu.javacourse.studentorder.exception.CityRegisterException;
import edu.javacourse.studentorder.exception.TransportException;
import edu.javacourse.studentorder.validator.register.CityRegisterChecker;
import edu.javacourse.studentorder.validator.register.FakeCityRegisterChecker;

import java.util.Iterator;

public class CityRegisterValidator {

    CityRegisterChecker checker;

    public CityRegisterValidator() {
        checker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder studentOrder) {
        AnswerCityRegister answerCityRegister = new AnswerCityRegister();
        answerCityRegister.withItem(checkPerson(studentOrder.getHusband()));
        answerCityRegister.withItem(checkPerson(studentOrder.getWife()));
        for (Child child : studentOrder.getChild()) {
            answerCityRegister.withItem(checkPerson(child));
        }
        return answerCityRegister;
    }

    public AnswerCityRegisterItem checkPerson(Person person) {
        AnswerCityRegisterItem.CityStatus status = null;
        AnswerCityRegisterItem.Error error = null;
        try {
            CityRegisterCheckerResponse cityRegisterCheckerResponse = checker.cityRegisterChecker(person);
            status = cityRegisterCheckerResponse.isExistence() ?
                    AnswerCityRegisterItem.CityStatus.YES :
                    AnswerCityRegisterItem.CityStatus.NO;

        } catch (CityRegisterException ex) {
            ex.printStackTrace();
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.Error(ex.getCode(), ex.getMessage());

        } catch (TransportException ex) {
            ex.printStackTrace();
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.Error(ex.getCode(), ex.getMessage());

        }
        AnswerCityRegisterItem answerCityRegisterItem = new AnswerCityRegisterItem(person, status , error);

        return answerCityRegisterItem;
    }

}
