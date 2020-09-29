package edu.javacourse.studentorder.domain;

import edu.javacourse.studentorder.domain.Adult;
import edu.javacourse.studentorder.domain.Child;

import java.util.ArrayList;
import java.util.List;

public class StudentOrder {
    private long studentOrderId;
    private Adult husband;
    private Adult wife;
    private List<Child> child;


    public long getStudentOrderId() {
        return studentOrderId;
    }

    public void setStudentOrderId(long studentOrderId) {
        this.studentOrderId = studentOrderId;
    }

    public Adult getHusband() {
        return husband;
    }

    public void setHusband(Adult husband) {
        this.husband = husband;
    }

    public Adult getWife() {
        return wife;
    }

    public void setWife(Adult wife) {
        this.wife = wife;
    }

    public List<Child> getChild() {
        return child;
    }

    public void withChild(Child child) {
        if (this.child.isEmpty() || this.child == null) this.child = new ArrayList<>();
        this.child.add(child);
    }
}
