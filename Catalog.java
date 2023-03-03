import java.util.ArrayList;

public class Catalog implements Subject {
    private static Catalog instance = null;
    private ArrayList<Course> courses;
    private ArrayList<Observer> abonati;

    private Catalog() {
        courses = new ArrayList<Course>();
        abonati = new ArrayList<Observer>();
    }
    public static Catalog getInstance() {
        if (instance == null) {
            instance = new Catalog();
        }
        return instance;
    }
    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    @Override
    public void addObserver(Observer observer) {
        abonati.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        abonati.remove(observer);
    }

    @Override
    public void notifyObservers(Grade grade) {
        for (Observer parinte : abonati) {
            if (grade.getStudent().getMother() == parinte || grade.getStudent().getFather() == parinte) {
                parinte.update(new Notification(grade));
            }
        }
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "courses=" + courses +
                '}';
    }
}
