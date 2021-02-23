import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Course. <br><br>
 * Invariants:
 * 1. MAXIMUM_QUOTA > 0
 * 2. MAXIMUM_QUOTA >= number of registered students. <br><br>
 *
 * @author Diego.Prado
 */
public class Course {

    public static final int MAXIMUM_QUOTA = 30;

    private int id;
    private int credits;
    private String name;
    private List<Student> registeredStudents;
    private Course[] preRequirements;

    public Course(int id, int credits, String name) {
        this.id = id;
        this.credits = credits;
        this.name = name;

        registeredStudents = new ArrayList<>();
    }

    /**
     * If is possible register a new student into de course. The condition are: <br><br>
     * 1. There is a quota into de course. <br>
     * 2. The student has not been registered into the course. <br>
     * 3. The student has the pre requirements. <br>
     * <br>
     *
     * @param student The student added:
     * @return true if the student was successfully registered, otherwise false.
     */
    public boolean register(Student student) {
        boolean result = false;
        boolean exist = false;

        if (MAXIMUM_QUOTA > this.registeredStudents.size())
        {
            for (int i=0; i < this.registeredStudents.size();i++){
                if(this.registeredStudents.get(i).equals(student)){
                    exist=true;
                }
            }
            if(!exist){
                result= this.registeredStudents.add(student);
            }

        }
        return result;
    }

}
