/**
 * Represents a Student. <br><br>
 * Invariants:
 *1. id. <br><br>
 *
 * @author Diego.Prado
 */
public class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }

        @Override
        public boolean equals(Object o){

        //verify not null
        if(o == null){
            return false;
        }

        //Object instance of Student
        if(!(o instanceof Student)){
            return false;
        }

        //casteo
        Student s = (Student)o;

        // Validation
        return this.id == s.getId();
    }
}

