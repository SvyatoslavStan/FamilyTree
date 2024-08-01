import java.time.LocalDate;

public class Person extends AbstractPerson {
    public Person(String name, String gender, LocalDate dateOfBirth) {
        super(name, gender, dateOfBirth);
    }

    @Override
    public String getFullInfo() {
        return name + " (Пол: " + gender + ", Дата рождения: " + dateOfBirth + ")";
    }

    @Override
    public String toString() {
        return getFullInfo();
    }
}