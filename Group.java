import java.util.Comparator;
import java.util.TreeSet;

public class Group extends TreeSet<Student> implements Comparable {
    private String ID;
    private Assistant assistant;
    private Comparator comp;

    public Group() {
    }
    public Group(String ID, Assistant assistant) {
        this.ID = ID;
        this.assistant = assistant;
    }

    public Group(String ID, Assistant assistant, Comparator<Student> comp) {
        this(ID, assistant);
        this.comp = comp;
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Assistant getAssistant() {
        return assistant;
    }
    public void setAssistant(Assistant assistant) {
        this.assistant = assistant;
    }

    public int compareTo(Object o) {
        Group obj = (Group) o;
        if (this.ID.compareTo(obj.getID()) == 0) {
            return 0;
        } else if (this.ID.compareTo(obj.getID()) > 0) {
                return 1;
        } else {
            return -1;
        }
    }
}
