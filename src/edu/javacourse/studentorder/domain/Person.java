package edu.javacourse.studentorder.domain;

import edu.javacourse.studentorder.domain.Address;

import java.time.LocalDate;

public abstract class Person {

    protected String surName; //
    protected String givenName; //
    protected String patronymic; //отчество
    protected LocalDate dateOfBirth;
    protected Address address;


    abstract public static class Builder<T extends Builder<T>> {

        public String surName; //
        public String givenName; //
        public String patronymic; //отчество
        public LocalDate dateOfBirth;
        public Address address;

        protected abstract T self();

        public T surName(String surName) {
            this.surName = surName;
            return self();
        }

        public T givenName(String givenName) {
            this.givenName = givenName;
            return self();
        }

        public T patronymic(String patronymic){
            this.patronymic = patronymic;
            return self();
        }

        T dateOfBirth(LocalDate dateOfBirth){
            this.dateOfBirth = dateOfBirth;
            return self();
        }

        T address(Address address){
            this.address = address;
            return self();
        }


        abstract Person build();
    }

    Person(Builder<?> builder) {
        this.surName = builder.surName;
        this.givenName = builder.givenName;
        this.patronymic = builder.patronymic;
        this.dateOfBirth = builder.dateOfBirth;
        this.address = builder.address;
    }

    public String getSurName() {
        return surName;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }
}
