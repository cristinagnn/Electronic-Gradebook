import java.util.ArrayList;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        Catalog catalog = Catalog.getInstance();

        User a1 = UserFactory.getUser("Assistant", "Asistent", "Unu");
        User a2 = UserFactory.getUser("Assistant", "Asistent", "Doi");
        User a3 = UserFactory.getUser("Assistant", "Asistent", "Trei");

        User t1 = UserFactory.getUser("Teacher", "Profesor", "Unu");
        User t2 = UserFactory.getUser("Teacher", "Profesor", "Doi");
        User t3 = UserFactory.getUser("Teacher", "Profesor", "Trei");

        User s1 = UserFactory.getUser("Student", "Student", "Unu");
        User s2 = UserFactory.getUser("Student", "Student", "Doi");
        User s3 = UserFactory.getUser("Student", "Student", "Trei");
        User s4 = UserFactory.getUser("Student", "Student", "Patru");
        User s5 = UserFactory.getUser("Student", "Student", "Cinci");
        User s6 = UserFactory.getUser("Student", "Student", "Sase");

        User m1 = UserFactory.getUser("Parent", "Mama", "Unu");
        User f1 = UserFactory.getUser("Parent", "Tata", "Unu");
        User m2 = UserFactory.getUser("Parent", "Mama", "Doi");
        User f2 = UserFactory.getUser("Parent", "Tata", "Doi");
        User m3 = UserFactory.getUser("Parent", "Mama", "Trei");
        User f3 = UserFactory.getUser("Parent", "Tata", "Trei");
        User m4 = UserFactory.getUser("Parent", "Mama", "Patru");
        User f4 = UserFactory.getUser("Parent", "Tata", "Patru");
        User m5 = UserFactory.getUser("Parent", "Mama", "Cinci");
        User f5 = UserFactory.getUser("Parent", "Tata", "Cinci");
        User m6 = UserFactory.getUser("Parent", "Mama", "Sase");
        User f6 = UserFactory.getUser("Parent", "Tata", "Sase");

        ((Student) s1).setMother((Parent) m1);
        ((Student) s1).setFather((Parent) f1);
        System.out.println(((Student) s1).getMother());
        System.out.println(((Student) s1).getFather());

        ((Student) s2).setMother((Parent) m2);
        ((Student) s2).setFather((Parent) f2);
        System.out.println(((Student) s2).getMother());
        System.out.println(((Student) s2).getFather());

        ((Student) s3).setMother((Parent) m3);
        ((Student) s3).setFather((Parent) f3);
        System.out.println(((Student) s3).getMother());
        System.out.println(((Student) s3).getFather());

        ((Student) s4).setMother((Parent) m4);
        ((Student) s4).setFather((Parent) f4);
        System.out.println(((Student) s4).getMother());
        System.out.println(((Student) s4).getFather());

        ((Student) s5).setMother((Parent) m5);
        ((Student) s5).setFather((Parent) f5);
        System.out.println(((Student) s5).getMother());
        System.out.println(((Student) s5).getFather());

        ((Student) s6).setMother((Parent) m6);
        ((Student) s6).setFather((Parent) f6);
        System.out.println(((Student) s6).getMother());
        System.out.println(((Student) s6).getFather());

        System.out.println(((Assistant) a1).getFirstName() + " " + ((Assistant) a1).getLastName());
        System.out.println(((Assistant) a2).getFirstName() + " " + ((Assistant) a2).getLastName());
        System.out.println(((Assistant) a3).getFirstName() + " " + ((Assistant) a3).getLastName());

        System.out.println(((Teacher) t1).getFirstName() + " " + ((Teacher) t1).getLastName());
        System.out.println(((Teacher) t2).getFirstName() + " " + ((Teacher) t2).getLastName());
        System.out.println(((Teacher) t3).getFirstName() + " " + ((Teacher) t3).getLastName());

        Group g1 = new Group("321CC", (Assistant) a1);
        Group g2 = new Group("322CC", (Assistant) a2);
        Group g3 = new Group();

        g3.setAssistant((Assistant) a3);
        g3.setID("323CC");

        System.out.println(g1.getID() + " " + g1.getAssistant());
        System.out.println(g2.getID() + " " + g2.getAssistant());
        System.out.println(g3.getID() + " " + g3.getAssistant());

        g1.add((Student) s1);
        g1.add((Student) s2);
        g2.add((Student) s3);
        g2.add((Student) s4);
        g3.add((Student) s5);
        g3.add((Student) s6);

        System.out.println(g1);
        System.out.println(g2);
        System.out.println(g3);

        PartialCourse c1 = (PartialCourse) new PartialCourse.PartialCourseBuilder("Curs1", (Teacher) t1,
                new BestPartialScore()).build();
        FullCourse c2 = (FullCourse) new FullCourse.FullCourseBuilder("Curs2", (Teacher) t2,
                new BestExamScore()).build();
        PartialCourse c3 = (PartialCourse) new PartialCourse.PartialCourseBuilder("Curs3", (Teacher) t3,
                new BestTotalScore()).build();

        Grade grade1 = new Grade((Student) s1, "Curs1");
        Grade grade2 = new Grade((Student) s2, "Curs1");
        Grade grade3 = new Grade((Student) s1, "Curs2");
        Grade grade4 = new Grade((Student) s2, "Curs2");
        Grade grade5 = new Grade((Student) s3, "Curs3");
        Grade grade6 = new Grade((Student) s4, "Curs3");
        Grade grade7 = new Grade((Student) s5, "Curs1");
        Grade grade8 = new Grade((Student) s6, "Curs3");

        // Partial Courses
        grade1.setExamScore(5d);
        grade1.setPartialScore(3d);

        grade2.setExamScore(5d);
        grade2.setPartialScore(2d);

        grade5.setExamScore(7d);
        grade5.setPartialScore(3d);

        grade6.setExamScore(2.5d);
        grade6.setPartialScore(2.5d);

        grade8.setExamScore(5d);
        grade8.setPartialScore(0.5d);

        // Full courses
        grade3.setExamScore(5d);
        grade3.setPartialScore(0d);

        grade4.setExamScore(3.2d);
        grade4.setPartialScore(0d);

        grade7.setExamScore(4d);
        grade7.setPartialScore(0d);

        c1.setCredits(5);
        c2.setCredits(2);
        c3.setCredits(4);

        catalog.addCourse(c1);
        catalog.addCourse(c2);
        catalog.addCourse(c3);
        System.out.println(catalog);
        catalog.removeCourse(c1);
        System.out.println(catalog);

        c1.addGroup(g1);
        c2.addGroup(g2);
        c3.addGroup(g3);
        System.out.println(catalog);

        c1.addAssistant("321CC", (Assistant) a3);
        c2.addAssistant("322CC", (Assistant) a2);
        c3.addAssistant("323CC", (Assistant) a3);
        System.out.println(catalog);

        c1.addStudent("321CC", (Student) s3);
        System.out.println(catalog);

        c1.addGroup(g2);
        System.out.println(catalog);

        c2.addGroup("324CC", (Assistant) a3);
        System.out.println(catalog);

        c1.addGrade(grade1);
        c1.addGrade(grade2);
        c1.addGrade(grade7);
        c2.addGrade(grade3);
        c2.addGrade(grade4);
        c3.addGrade(grade5);
        c3.addGrade(grade6);
        c3.addGrade(grade8);
        System.out.println(catalog);

        System.out.println(c1.getGrade((Student) s1));
        HashMap<Student, Grade> H1 = new HashMap<>();
        H1 = c1.getAllStudentGrades();

        HashMap<Student, Grade> H2 = new HashMap<>();
        H2 = c2.getAllStudentGrades();

        HashMap<Student, Grade> H3 = new HashMap<>();
        H3 = c3.getAllStudentGrades();

        System.out.println("Curs 1" + "\n");
        for (Grade nota : H1.values()) {
                System.out.println(nota.getStudent().toString() +
                        "\n" + "- Nota examen: " + nota.getExamScore() +
                        "\n" + "- Nota partial: " + nota.getPartialScore() +
                        "\n" + "- Nota finala: " + nota.getTotal());
        }

        System.out.println("Curs 2" + "\n");
        for (Grade nota : H2.values()) {
            System.out.println(nota.getStudent().toString() +
                    "\n" + "- Nota examen: " + nota.getExamScore() +
                    "\n" + "- Nota partial: " + nota.getPartialScore() +
                    "\n" + "- Nota finala: " + nota.getTotal());
        }

        System.out.println("Curs 3" + "\n");
        for (Grade nota : H3.values()) {
            System.out.println(nota.getStudent().toString() +
                    "\n" + "- Nota examen: " + nota.getExamScore() +
                    "\n" + "- Nota partial: " + nota.getPartialScore() +
                    "\n" + "- Nota finala: " + nota.getTotal());
        }

        ArrayList<Student> A1 = new ArrayList<Student>();
        A1 = c1.getAllStudents();

        ArrayList<Student> A2 = new ArrayList<Student>();
        A2 = c2.getAllStudents();

        ArrayList<Student> A3 = new ArrayList<Student>();
        A3 = c3.getAllStudents();

        for (Student st : A1) {
            System.out.println(st);
        }

        for (Student st : A2) {
            System.out.println(st);
        }

        for (Student st : A3) {
            System.out.println(st);
        }

        System.out.println(c1.getGraduatedStudents());
        System.out.println(c2.getGraduatedStudents());
        System.out.println(c3.getGraduatedStudents());

        catalog.addObserver((Parent) m1);
        catalog.addObserver((Parent) f1);
        catalog.notifyObservers(grade1);
        catalog.notifyObservers(grade3);

        System.out.println("Strategy c1: " + c1.getBestStudent()); // partial score
        System.out.println("Strategy c2: " + c2.getBestStudent()); // exam score
        System.out.println("Strategy c3: " + c3.getBestStudent()); // total score
    }
}
