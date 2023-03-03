import java.util.ArrayList;

public class FullCourse extends Course {
    public FullCourse(FullCourseBuilder builder) {
        super(builder);
    }

    public static class FullCourseBuilder extends Course.CourseBuilder {
        public FullCourseBuilder(String name, Teacher titular) {
            super(name, titular);
        }
        public FullCourseBuilder(String name, Teacher titular, Strategy strategy) {
            super(name, titular, strategy);
        }

        public Course build() {
            return new FullCourse(this);
        }
    }
    public ArrayList<Student> getGraduatedStudents() {
        ArrayList<Student> promovati = new ArrayList<Student>();
        for (Grade gr : getGrades()) {
            if (gr.getPartialScore() >= 3 && gr.getExamScore() >= 2) {
                promovati.add(gr.getStudent());
            }
        }
        return promovati;
    }
}
