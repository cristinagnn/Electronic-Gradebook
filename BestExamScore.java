import java.util.ArrayList;

public class BestExamScore implements Strategy {

    @Override
    public Student getBestStudent(ArrayList<Grade> grades) {
        Grade best = grades.get(0);
        for(Grade st : grades) {
            if(st.getExamScore() > best.getExamScore()) {
                best = st;
            }
        }
        return best.getStudent();
    }
}
