package edu.javacourse.studentorder.domain;

import java.time.LocalDate;

public class Adult extends Person {
    private String passportSeria;
    private String passportNumber;
    private LocalDate issueDate; //дата выдачи
    private LocalDate issueDepartment; //депортамент выдачи
    private String university;
    private String studentId;

    public static class Builder extends Person.Builder<Builder> {

        public String passportSeria;
        private String passportNumber;
        private LocalDate issueDate; //дата выдачи
        private LocalDate issueDepartment; //депортамент выдачи
        private String university;
        private String studentId;

        public Builder passportSeria(String passportSeria) {
            this.passportSeria = passportSeria;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Adult build() {
            return new Adult(this);
        }

    }

    Adult(Builder builder) {
        super(builder);
        this.passportSeria = builder.passportSeria;

    }

    public String show() {
        return surName;
    }

    public String getUniversity() {
        return university;
    }


    public String getStudentId() {
        return studentId;
    }


    public String getPassportSeria() {
        return passportSeria;
    }


    public String getPassportNumber() {
        return passportNumber;
    }


    public LocalDate getIssueDate() {
        return issueDate;
    }


    public LocalDate getIssueDepartment() {
        return issueDepartment;
    }


}
