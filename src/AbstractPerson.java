import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPerson implements Serializable {
    protected String name;
    protected AbstractPerson father;
    protected AbstractPerson mother;
    protected List<AbstractPerson> children;
    protected String gender;
    protected LocalDate dateOfBirth;

    public AbstractPerson(String name, String gender, LocalDate dateOfBirth) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public AbstractPerson getFather() {
        return father;
    }

    public void setFather(AbstractPerson father) {
        this.father = father;
    }

    public AbstractPerson getMother() {
        return mother;
    }

    public void setMother(AbstractPerson mother) {
        this.mother = mother;
    }

    public List<AbstractPerson> getChildren() {
        return children;
    }

    public void addChild(AbstractPerson child) {
        this.children.add(child);
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public abstract String getFullInfo();
}