package com.example.courseworkserver.util;


import com.example.courseworkserver.dao.UniobjectDao;
import com.example.courseworkserver.entity.Uniobject;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UniobjectUtil {
    static String pathToEntityPackage = "com.example.courseworkserver.entity.";

    public static <E extends Uniobject> E generateClassByUniobj(Uniobject uniobject) {
        String className = UniobjectDao.getNameOfClassUniObj(uniobject);
        String fullPathToClass = pathToEntityPackage + className;
        try {
            List<Class<?>> classes = new ArrayList<>();
            Class<?> c = Class.forName(fullPathToClass);
            Class<?> tempClass = Class.forName(fullPathToClass);
            while (!tempClass.getName().equals("java.lang.Object")){
                classes.add(tempClass);
                tempClass = tempClass.getSuperclass();
            }
            for (Class<?> clas: classes ){
                for (Field field: clas.getDeclaredFields()){
                    System.out.println(field);
                    System.out.println(field.getType());
                    String str = "1";

                }
            }
            List<Object> objectsList = new ArrayList<>();
            Constructor<?> constructor = c.getConstructor(getParameterTypes(UniobjectDao.mapForFillUniobj(uniobject)));
            UniobjectDao.mapForFillUniobj(uniobject).forEach((k, v) -> {
                System.out.println("key: "+ k);
                System.out.println("value: " + v);
                objectsList.add(v);
            });

            Object[] arr = objectsList.toArray();
            return (E) constructor.newInstance(arr);



        }catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException| IllegalAccessException e){
            throw new RuntimeException(e);
        }

    }

    public static List<String> getAllTablesNameRelatedToUniobj(Uniobject uniobject) {
        List<String> tablesName = new ArrayList<>();
        Class<?> concreteClass = getUnioBjectClass(uniobject);
        tablesName.add(getNameOfTableByClass(concreteClass));
        while (concreteClass.getSuperclass() != Object.class){
            concreteClass = concreteClass.getSuperclass();
            tablesName.add(getNameOfTableByClass(concreteClass));
        }
        return tablesName;
    }

    public static List<String> getAllTablesNameRelatedToUniobjById(Integer uniobjectId) {
        List<String> tablesName = new ArrayList<>();
        Class<?> concreteClass = getUnioBjectClassById(uniobjectId);
        tablesName.add(getNameOfTableByClass(concreteClass));
        while (concreteClass.getSuperclass() != Object.class){
            concreteClass = concreteClass.getSuperclass();
            tablesName.add(getNameOfTableByClass(concreteClass));
        }
        return tablesName;
    }

    public static String getNameOfTableByClass(Class<?> concreteClass){

            throw new RuntimeException("Such anotations do not exist");

    }

    private static Class<?> getUnioBjectClass(Uniobject uniobject){
        String className = UniobjectDao.getNameOfClassUniObj(uniobject);
        String fullPathToClass = pathToEntityPackage + className;
        try {
            return Class.forName(fullPathToClass);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static Class<?> getUnioBjectClassById(Integer uniobjectId){
        String className = UniobjectDao.getNameOfClassUniObjById(uniobjectId);
        String fullPathToClass = pathToEntityPackage + className;
        try {
            return Class.forName(fullPathToClass);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static Class<?>[] getParameterTypes(Map<String, Object> uniobject) {
        Class<?>[] parameterTypes = new Class<?>[uniobject.size()];
        int i = 0;
        for (Object value : uniobject.values()) {
            parameterTypes[i++] = value.getClass();
        }
        return parameterTypes;
    }
}
