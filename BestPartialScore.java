import java.util.ArrayList;

public class BestPartialScore implements Strategy {
    @Override
    public Student getBestStudent(ArrayList<Grade> grades) {
        Grade best = grades.get(0);
        for (Grade st : grades) {
            if (st.getPartialScore() > best.getPartialScore()) {
                best = st;
            }
        }
        return best.getStudent();
    }
}
