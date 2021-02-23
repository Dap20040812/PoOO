import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClasedePrueba {

    @Test
    @DisplayName("GIVEN a course with quota WHEN register a Student THEN should allow")
    public void shouldAllowRegisterAStudent() {

        Student student = new Student(1,"juan");
        Course course = new Course(1,4,"POOB");

        boolean result = course.register(student);
        assertTrue(result, "The student was successfully registered");
    }

    @Test
    @DisplayName("GIVEN a course with the Student registered WHEN the same Student is registered THEN should not allow")
    public void shouldNotAllowRegisterStudentTwice(){
        Student student1 = new Student(1, "juan");
        Student student2 = new Student(1, "Pedro");

        Course course = new Course(1,4,"POOB");


        assertTrue(course.register(student1), "The student was successfully registered");
        assertFalse(course.register(student2), "The student was not successfully registered");

    }

    @Test
    @DisplayName("GIVEN a course with no quota WHEN register a Student THEN should not allow")
    public void shouldNotAllowRegisterAStudentWithCourseWithoutQuota(){
        Course course = new Course(1,4,"POOB");

        for(int i=0; i < course.MAXIMUM_QUOTA; i++){
            int id = i+1;
            Student student = new Student(id,"Juan - "+id);
            assertTrue(course.register(student), "The student was successfully registered");
        }
        Student student = new Student(course.MAXIMUM_QUOTA+1,"Juanes");
        boolean result = course.register(student);
        assertFalse(result, "The student was not successfully registered");


    }

}
