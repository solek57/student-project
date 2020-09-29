package edu.javacourse.studentorder.domain.register;

import edu.javacourse.studentorder.domain.Person;

public class AnswerCityRegisterItem {
    public enum CityStatus {
        YES, NO, ERROR;
    }

    public static class Error {
        private String code;
        private String text;

        public Error(String code, String text) {
            this.code = code;
            this.text = text;
        }

        public String getCode() {
            return code;
        }

        public String getText() {
            return text;
        }
    }

    private Person person;
    private CityStatus status;
    private Error error;

    public AnswerCityRegisterItem(Person person, CityStatus status, Error error) {
        this.person = person;
        this.status = status;
        this.error = error;
    }

    public AnswerCityRegisterItem(Person person, CityStatus status) {
        this.person = person;
        this.status = status;
    }

    public AnswerCityRegisterItem(Person person, Error error) {
        this.person = person;
        this.error = error;
    }

    public Person getPerson() {
        return person;
    }

    public CityStatus getStatus() {
        return status;
    }

    public Error getError() {
        return error;
    }
}
