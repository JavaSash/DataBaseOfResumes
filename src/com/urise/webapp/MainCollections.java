package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MainCollections {
    private static final String NO_NAME = "No name";
    private static final String UUID_1 = "uuid1";
    private static final Resume RESUME1 = new Resume(UUID_1, NO_NAME);

    private static final String UUID_2 = "uuid2";
    private static final Resume RESUME2 = new Resume(UUID_2, NO_NAME);

    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME3 = new Resume(UUID_3, NO_NAME);

    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME_4 = new Resume(UUID_4, NO_NAME);

    public static void main(String[] args) {
        Collection<Resume> collection = new ArrayList<>();
        collection.add(RESUME1);
        collection.add(RESUME2);
        collection.add(RESUME3);

//        for (Resume resume : collection) {
//            System.out.println(resume);
//            if (Objects.equals(resume.getUuid(), UUID_1)) {
//                collection.remove(resume);
//            }
//        }

        Iterator<Resume> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Resume resume = iterator.next();
            System.out.println(resume);
            if (Objects.equals(resume.getUuid(), UUID_1)) {
                iterator.remove();
            }
        }
        System.out.println(collection.toString());

        Map<String, Resume> map = new HashMap<>();
        {
            map.put(UUID_1, RESUME1);
            map.put(UUID_2, RESUME2);
            map.put(UUID_3, RESUME3);
        }

        //Bad!
        for (String uuid : map.keySet()) {
            System.out.println(map.get(uuid));
        }

        for (Map.Entry<String, Resume> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }

        List<Resume> resumes = Arrays.asList(RESUME1, RESUME2, RESUME3);
        //remove с дефолтной реализацией, т.к. private static ArrayList
        // - nested класс Arrays-а и представляет собой неизменяемый
        // список, в котором add() и remove() с дефолтной реализацией
        // (т.е. бросают UnsupportedOperationExc)
        //resumes.remove(1);
        System.out.println(resumes);
    }
}
