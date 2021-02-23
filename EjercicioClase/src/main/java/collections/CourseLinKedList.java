package collections;

import entities.Student;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;

public class CourseLinKedList implements CourseCollectionsExample {

    public static final int MAXIMUM_QUOTA = 30;

    private LinkedList<Student> students;

    public CourseLinKedList() {
        students = new LinkedList<>();
    }

    @Override
    public int numMaxStudents() {
        return MAXIMUM_QUOTA;
    }

    @Override
    public int numRegisteredStudents() {

        return students.size();
    }

    @Override
    public boolean addStudent(Student s) {
        boolean result = false;
        boolean exists = false;

        if (numRegisteredStudents() < MAXIMUM_QUOTA) {
            for (int i = 0; i < numRegisteredStudents() && !exists; i++) {
                if (students.get(i).equals(s)) {
                    exists = true;
                }
            }

            if (!exists) {
                students.add(s);
                result = true;
            }
        }

        return result;
    }

    @Override
    public boolean removeStudent(Student s) {

        return students.remove(s);
    }

    @Override
    public Student getStudent(Student s) {
        int i;
        boolean found = false;
        for (i = 0; i < numRegisteredStudents() && !found; i++) {
            found = students.contains(s);
        }
        return found ? students.get(i - 1) : null;



    }

    @Override
    public Student updateStudent(Student s) {

        Student result = null;
        boolean exist = false;
        for(int i=0; i < students.size() && !exist;i++)
        {
            if(students.get(i).equals(s))
            {
                students.add(i,s);
                exist=true; 
                result = s;
            }
        }

        return result;
    }
}
