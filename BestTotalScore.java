import java.util.ArrayList;

public class BestTotalScore implements Strategy {
    @Override
    public Student getBestStudent(ArrayList<Grade> grades) {
        Grade best = grades.get(0);
        for (Grade st : grades) {
            if (st.getTotal() > best.getTotal()) {
                best = st;
            }
        }
        return best.getStudent();
    }
}
