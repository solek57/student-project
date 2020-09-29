package edu.javacourse.studentorder.validator.register;

import edu.javacourse.studentorder.domain.Adult;
import edu.javacourse.studentorder.domain.register.CityRegisterCheckerResponse;
import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.exception.CityRegisterException;
import edu.javacourse.studentorder.exception.TransportException;

public class FakeCityRegisterChecker implements CityRegisterChecker {
    @Override
    public CityRegisterCheckerResponse cityRegisterChecker(Person person) throws CityRegisterException, TransportException {
        if (person instanceof Adult) {
            Adult adult = (Adult) person;
            if ("10001".equals(adult.getPassportSeria()) || "20001".equals(adult.getPassportSeria())) {
                return new CityRegisterCheckerResponse(true, Boolean.FALSE);
            } else {
                throw new CityRegisterException("Not valid passport seria Adult: " + adult.getPassportSeria() + " " + adult.getSurName());
            }
        }
        return null;
    }

}
