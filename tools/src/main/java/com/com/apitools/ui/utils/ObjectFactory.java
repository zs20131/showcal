package com.com.apitools.ui.utils;

import com.com.apitools.ui.utils.message.Messages;

import java.util.ArrayList;
import java.util.List;


public class ObjectFactory {

    private static List<ClassLoader> externalClassLoaders;

    static {
        externalClassLoaders = new ArrayList<ClassLoader>();
    }

    private ObjectFactory(){
        super();
    }

    public static synchronized void addExternalClassLoader(ClassLoader classLoader) {
        ObjectFactory.externalClassLoaders.add(classLoader);
    }

    public static Class<?> externalClassForName(String type) throws ClassNotFoundException {

        Class<?> clazz;

        for (ClassLoader classLoader : externalClassLoaders) {
            try {
                classLoader.loadClass(type);
                clazz = Class.forName(type, true, classLoader);
                return clazz;
            } catch (Throwable e) {

            }
        }

        return internalClassForName(type);
    }

    public static Class<?> internalClassForName(String type) throws ClassNotFoundException {
        Class<?> clazz = null;

        try {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            clazz = Class.forName(type, true, cl);
        } catch (Exception e) {
            // ignore - failsafe below
        }

        if (clazz == null) {
            clazz = Class.forName(type, true, ObjectFactory.class.getClassLoader());
        }

        return clazz;
    }

    public static Object createExternalObject(String type) {
        Object answer;

        try {
            Class<?> clazz = externalClassForName(type);
            answer = clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(Messages.getString("RuntimeError.5", type), e); //$NON-NLS-1$
        }

        return answer;
    }

}
