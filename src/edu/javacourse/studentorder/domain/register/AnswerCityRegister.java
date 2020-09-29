package edu.javacourse.studentorder.domain.register;

import java.util.ArrayList;
import java.util.List;

public class AnswerCityRegister {
    List<AnswerCityRegisterItem> item;

    public List<AnswerCityRegisterItem> withItem(AnswerCityRegisterItem answerCityRegisterItem) {
        if (item == null) {
            item = new ArrayList<>(10);
        }
        item.add(answerCityRegisterItem);
        return item;
    }
}
