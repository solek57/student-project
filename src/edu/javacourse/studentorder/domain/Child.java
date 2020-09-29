package edu.javacourse.studentorder.domain;

import java.time.LocalDate;

public class Child extends Person {
    private String sertificateNumber;
    private LocalDate issueDate;
    private String issueDepartment;


    public static class Builder extends Person.Builder<Builder> {
        private String sertificateNumber;
        private LocalDate issueDate;
        private String issueDepartment;

        public Builder issueDepartment(String issueDepartment) {
            this.issueDepartment = issueDepartment;
            return this;
        }

        public Builder issueDate(LocalDate issueDate) {
            this.issueDate = issueDate;
            return this;
        }

        public Builder sertficateNumber(String sertificateNumber) {
            this.sertificateNumber = sertificateNumber;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Child build() {
            return new Child(this);
        }
    }

    Child(Builder builder) {
        super(builder);
        this.sertificateNumber = builder.sertificateNumber;
    }

    public String getSertificateNumber() {
        return sertificateNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public String getIssueDepartment() {
        return issueDepartment;
    }
}
