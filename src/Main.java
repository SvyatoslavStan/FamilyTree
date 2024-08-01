import java.time.LocalDate;
import java.time.Period;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Person stan = new Person("Стэн", "Мужской", LocalDate.of(1976, 11, 27));
        Person maria = new Person("Мария", "Женский", LocalDate.of(1978, 3, 20));
        Person anna = new Person("Анна", "Женский", LocalDate.of(2005, 11, 10));
        Person igor = new Person("Игорь", "Мужской", LocalDate.of(2007, 7, 5));
        Person alexander = new Person("Александр", "Мужской", LocalDate.of(2009, 9, 1));

        stan.setMother(maria);
        anna.setFather(stan);
        anna.setMother(maria);
        igor.setFather(stan);
        igor.setMother(maria);
        alexander.setFather(stan);
        alexander.setMother(maria);

        stan.addChild(anna);
        stan.addChild(igor);
        stan.addChild(alexander);
        maria.addChild(anna);
        maria.addChild(igor);
        maria.addChild(alexander);

        familyTree.addPerson(stan);
        familyTree.addPerson(maria);
        familyTree.addPerson(anna);
        familyTree.addPerson(igor);
        familyTree.addPerson(alexander);

        IFamilyResearch research = new FamilyResearch(familyTree);

        System.out.println("Дети Стэна: " + research.getChildren("Стэн"));
        System.out.println("Родители Анны: " + java.util.Arrays.toString(research.getParents("Анна")));
        System.out.println("Братья и сестры Игоря: " + research.getSiblings("Игорь"));
        System.out.println("Информация о Стэне: " + stan);
        System.out.println("Информация о Марии: " + maria);
        System.out.println("Возраст Стэна: " + calculateAge(stan.getDateOfBirth()) + " лет");
        System.out.println("Возраст Марии: " + calculateAge(maria.getDateOfBirth()) + " лет");

        IFileOperations fileOps = new FileOperations(familyTree);

        try {
            fileOps.saveToFile("family_tree.ser");
            System.out.println("Семейное дерево сохранено в файл.");

            fileOps.loadFromFile("family_tree.ser");
            System.out.println("Семейное дерево загружено из файла.");

            FamilyTree loadedTree = ((FileOperations) fileOps).getFamilyTree();
            IFamilyResearch loadedResearch = new FamilyResearch(loadedTree);

            System.out.println("Проверка загруженных данных:");
            System.out.println("Дети Стэна: " + loadedResearch.getChildren("Стэн"));
            System.out.println("Родители Анны: " + java.util.Arrays.toString(loadedResearch.getParents("Анна")));
            System.out.println("Братья и сестры Игоря: " + loadedResearch.getSiblings("Игорь"));

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}