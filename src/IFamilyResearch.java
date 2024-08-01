import java.util.List;

public interface IFamilyResearch {
    List<Person> getChildren(String name);
    Person[] getParents(String name);
    List<Person> getSiblings(String name);
}