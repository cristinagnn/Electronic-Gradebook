import java.util.*;

public abstract class Course {

    private String name;
    private Teacher titular;
    private HashSet<Assistant> assistants;
    private HashMap<String, Group> groups;
    private ArrayList<Grade> grades;
    private int credits;
    private Strategy strategy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTitular() {
        return titular;
    }

    public void setTitular(Teacher titular) {
        this.titular = titular;
    }

    public HashSet<Assistant> getAssistants() {
        return assistants;
    }

    public void setAssistants(HashSet<Assistant> assistants) {
        this.assistants = assistants;
    }

    public HashMap<String, Group> getGroups() {
        return groups;
    }

    public void setGroups(HashMap<String, Group> groups) {
        this.groups = groups;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Grade> grades) {
        this.grades = grades;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Course " +
                "name = " + name + '\'' +
                ", titular =" + titular +
                ", assistants =" + assistants +
                ", groups =" + groups +
                ", grades =" + grades +
                ", credits =" + credits + ".";
    }

    // Seteaza asistentul la grupa cu ID-ul mentionat si il adauga in multimea asistentilor daca nu exista deja
    public void addAssistant(String ID, Assistant assistant) {
        for (Map.Entry<String, Group> set : groups.entrySet()) {
            if (set.getKey().equals(ID)) {
                set.getValue().setAssistant(assistant);
            }
        }

        if (!assistants.contains(assistant)) {
            assistants.add(assistant);
        }
    }

    // Adauga studentul in grupa cu ID-ul indicat
    public void addStudent(String ID, Student student) {
        for (Map.Entry<String, Group> set : groups.entrySet()) {
            if (set.getKey().equals(ID)) {
                set.getValue().add(student);
            }
        }
    }

    // Adauga grupa in multimea grupelor
    public void addGroup(Group group) {
        groups.put(group.getID(), group);
    }

    // Instantiaza o grupa si o adauga
    public void addGroup(String ID, Assistant assistant) {
        Group group = new Group(ID, assistant);
        groups.put(ID, group);
    }

    // Instantiaza o grupa si o adauga
    public void addGroup(String ID, Assistant assistant, Comparator<Student> comp) {
        Group group = new Group(ID, assistant, comp);
        groups.put(ID, group);
    }

    // Returneaza nota unui student sau null
    public Grade getGrade(Student student) {
        for (Grade nota : grades) {
            if (nota.getStudent().equals(student)) {
                return nota;
            }
        }
        return null;
    }

    // Adauga o nota
    public void addGrade(Grade grade) {
        grades.add(grade);
        Collections.sort(grades);
    }

    // Returneaza o lista cu toti studentii
    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<Student>();
        for (Group set : groups.values()) {
            students.addAll(set);
        }
        return students;
    }


    // Returneaza un dictionar cu situatia studentilor
    public HashMap<Student, Grade> getAllStudentGrades() {
        HashMap<Student, Grade> situatione = new HashMap<Student, Grade>();
        for (Grade nota : grades) {
            if(!situatione.containsKey(nota.getStudent())) {
                situatione.put(nota.getStudent(), nota);
            }
        }
        return situatione;
    }

    // Metoda abstracta
    public abstract ArrayList<Student> getGraduatedStudents();

    // Va returna cel mai bun student
    public Student getBestStudent() {
        return strategy.getBestStudent(grades);
    }

    // Constructor
    protected Course (CourseBuilder builder) {
        this.name = builder.name;
        this.titular = builder.titular;
        this.assistants = builder.assistants;
        this.grades = builder.grades;
        this.groups = builder.groups;
        this.credits = builder.credits;
        this.strategy = builder.strategy;
    }

    // Clasa Builder
    public static abstract class CourseBuilder {
        private String name;
        private Teacher titular;
        private HashSet<Assistant> assistants;
        private HashMap<String, Group> groups;
        private ArrayList<Grade> grades;
        private int credits;
        private Strategy strategy;

        public CourseBuilder() {
            assistants = new HashSet<Assistant>();
            groups = new HashMap<String, Group>();
            grades = new ArrayList<Grade>();
        }
        public CourseBuilder(String name, Teacher titular) {
            this.name = name;
            this.titular = titular;
            assistants = new HashSet<Assistant>();
            groups = new HashMap<String, Group>();
            grades = new ArrayList<Grade>();
        }

        public CourseBuilder(String name, Teacher titular, Strategy strategy) {
            this.name = name;
            this.titular = titular;
            this.strategy = strategy;
            assistants = new HashSet<Assistant>();
            groups = new HashMap<String, Group>();
            grades = new ArrayList<Grade>();
        }
        public CourseBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CourseBuilder titular(Teacher titular) {
            this.titular = titular;
            return this;
        }

        public CourseBuilder assistants(HashSet<Assistant> assistants) {
            this.assistants = assistants;
            return this;
        }

        public CourseBuilder groups(HashMap<String, Group> groups) {
            this.groups = groups;
            return this;
        }

        public CourseBuilder grades(ArrayList<Grade> grades) {
            this.grades = grades;
            return this;
        }

        public CourseBuilder credits(int credits) {
            this.credits = credits;
            return this;
        }

        public CourseBuilder strategy(Strategy strategy) {
            this.strategy = strategy;
            return this;
        }

    }
}
