package edu.javacourse.studentorder.dao;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RunnerSimple {

    public static void main(String[] args) {
        RunnerSimple runnerSimple = new RunnerSimple();
        runnerSimple.runTestr();
    }

    private void runTestr() {
        try {
            Class cl = Class.forName("edu.javacourse.studentorder.dao.DictionaryDaoImplTest");
            Constructor constructor = cl.getConstructor();
            Object o = constructor.newInstance();
            Method[] methods = cl.getMethods();
            for (Method method : methods){
                Test test = method.getAnnotation(Test.class);
                if (test !=null){
                    method.invoke(o);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
