public class Student extends User implements Comparable {
    private Parent mother;
    private Parent father;

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Parent getMother() {
        return mother;
    }
    public void setMother(Parent mother) {
        this.mother = mother;
    }

    public Parent getFather() {
        return father;
    }

    public void setFather(Parent father) {
        this.father = father;
    }

    @Override
    public int compareTo(Object o) {
        Student obj = (Student) o;
        int cmp = this.getLastName().compareTo(obj.getLastName());
        if(cmp == 0) {
            int cmp2 = this.getFirstName().compareTo(obj.getFirstName());
            return cmp2;
        }
        return cmp;
    }

    @Override
    public String toString() {
        return "Student: " +
                "Prenume: " + getFirstName() +
                ", nume de familie: " + getLastName();
    }
}
