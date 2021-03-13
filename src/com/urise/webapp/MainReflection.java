package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException, InstantiationException {
        Resume resume = new Resume();
        /*Field field = resume.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(resume));
        field.set(resume, "new_uuid");
        System.out.println(resume);
        field.setAccessible(false);*/

// TODO : invoke r.toString via reflection

        Method method = Resume.class.getDeclaredMethod("toString");
        System.out.println("Result of calling method toString " + method.invoke(resume));
    }
}
