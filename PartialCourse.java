import java.util.ArrayList;
import java.util.Map;

public class PartialCourse extends Course {

    public PartialCourse(PartialCourseBuilder builder) {
        super(builder);
    }

    public static class PartialCourseBuilder extends Course.CourseBuilder {
        public PartialCourseBuilder(String name, Teacher titular) {
            super(name, titular);
        }

        public PartialCourseBuilder(String name, Teacher titular, Strategy strategy) {
            super(name, titular, strategy);
        }

        public Course build() {
            return new PartialCourse(this);
        }
    }
    public ArrayList<Student> getGraduatedStudents() {
        ArrayList<Student> promovati = new ArrayList<Student>();
        for (Grade gr : getGrades()) {
            if (gr.getTotal() >= 5) {
                promovati.add(gr.getStudent());
            }
        }
        return promovati;
    }
}
