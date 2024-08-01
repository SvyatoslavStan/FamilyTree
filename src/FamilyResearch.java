import java.util.List;
import java.util.stream.Collectors;

public class FamilyResearch implements IFamilyResearch {
    private FamilyTree familyTree;

    public FamilyResearch(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public List<Person> getChildren(String name) {
        AbstractPerson person = familyTree.findPerson(name);
        if (person != null) {
            return person.getChildren().stream()
                .map(child -> (Person) child)
                .collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public Person[] getParents(String name) {
        AbstractPerson person = familyTree.findPerson(name);
        if (person != null) {
            return new Person[]{(Person) person.getFather(), (Person) person.getMother()};
        }
        return null;
    }

    @Override
    public List<Person> getSiblings(String name) {
        AbstractPerson person = familyTree.findPerson(name);
        if (person != null) {
            AbstractPerson father = person.getFather();
            AbstractPerson mother = person.getMother();
            if (father != null) {
                return father.getChildren().stream()
                        .filter(child -> !child.equals(person))
                        .map(child -> (Person) child)
                        .collect(Collectors.toList());
            } else if (mother != null) {
                return mother.getChildren().stream()
                        .filter(child -> !child.equals(person))
                        .map(child -> (Person) child)
                        .collect(Collectors.toList());
            }
        }
        return null;
    }
}