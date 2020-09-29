package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.Adult;
import edu.javacourse.studentorder.domain.Child;
import edu.javacourse.studentorder.domain.StudentOrder;

public class SaveStudentOrder {
    public static void main(String[] args) {

    }

    public static StudentOrder buildStudentOrder(long i) {
        Child child = new Child.Builder()
                .surName("alex")
                .givenName("Ivanov")
                .patronymic("Sergeevish")
                .sertficateNumber("" + 3000 + i)
                .build();

        Adult husband = new Adult.Builder()
                .surName("Sergey")
                .givenName("Ivanov")
                .patronymic("Ivanovich")
                .passportSeria("" + 1000 + i)
                .build();

        Adult wife = new Adult.Builder()
                .surName("Maria")
                .givenName("Ivanova")
                .patronymic("Stepanovna")
                .passportSeria("" + 2000 + i)
                .build();

        StudentOrder studentOrder = new StudentOrder();
        studentOrder.setStudentOrderId(i);
        studentOrder.withChild(child);
        studentOrder.setHusband(husband);
        studentOrder.setWife(wife);
        return studentOrder;
    }

    public static void saveStudentOrder() {
        StudentOrder so = new StudentOrder();
    }
}