import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<AbstractPerson> people;
    
    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addPerson(AbstractPerson person) {
        people.add(person);
    }

    public List<AbstractPerson> getPeople() {
        return people;
    }

    public AbstractPerson findPerson(String name) {
        for (AbstractPerson person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (AbstractPerson person : people) {
            sb.append(person.getFullInfo()).append("\n");
        }
        return sb.toString();
    }
}